/**
 * edatagrid - jQuery EasyUI
 * 
 * Licensed under the GPL:
 *   http://www.gnu.org/licenses/gpl.txt
 *
 * Copyright 2011 stworthy [ stworthy@gmail.com ] 
 * 
 * Dependencies:
 *   datagrid
 *   messager
 * 
 */
(function($){
	function buildGrid(target){
		var opts = $.data(target, 'edatagrid').options;
		$(target).datagrid($.extend({}, opts, {
			onDblClickCell:function(index,field){
				if (opts.editing){
					$(this).edatagrid('editRow', index);
					focusEditor(field);
				}
			},
			onClickCell:function(index,field){
				if (opts.editing && opts.editIndex >= 0){
					$(this).edatagrid('editRow', index);
					focusEditor(field);
				}
			},
			onAfterEdit: function(index, row){
				opts.editIndex = undefined;
				var url = row.isNewRecord ? opts.saveUrl : opts.updateUrl;
				if (url){
					$.post(url, row, function(result){
						if (result.success){
							result.isNewRecord = null;
							$(target).datagrid('updateRow', {
								index: index,
								row: result.data
							});
							if (opts.tree){
								var t = $(opts.tree);
								var node = t.tree('find', row.id);
								if (node){
									node.text = row[opts.treeTextField];
									t.tree('update', node);
								} else {
									var pnode = t.tree('find', row[opts.treeParentField]);
									t.tree('append', {
										parent: (pnode ? pnode.target : null),
										data: [{id:row.id,text:row[opts.treeTextField]}]
									});
								}
							}
							opts.onSave.call(target, index, row);
						}else{
							$.messager.show({
								title   : '<span class="red">操作失败</span>',
								msg     : result.msg || '操作失败',
								timeout : 3000,
								showType: 'fade'
							});
						}
					},'json');
				}
				if (opts.onAfterEdit) opts.onAfterEdit.call(target, index, row);
			},
			onCancelEdit: function(index, row){
				opts.editIndex = undefined;
				if (row.isNewRecord) {
					$(this).datagrid('deleteRow', index);
				}
				if (opts.onCancelEdit) opts.onCancelEdit.call(target, index, row);
			},
			onBeforeLoad: function(param){
				$(this).datagrid('rejectChanges');
				if (opts.tree){
					var node = $(opts.tree).tree('getSelected');
					param[opts.treeParentField] = node ? node.id : undefined;
				}
				if (opts.onBeforeLoad) opts.onBeforeLoad.call(target, param);
			}
		}));
		
		function focusEditor(field){
			var editor = $(target).datagrid('getEditor', {index:opts.editIndex,field:field});
			if (editor){
				editor.target.focus();
			} else {
				var editors = $(target).datagrid('getEditors', opts.editIndex);
				if (editors.length){
					editors[0].target.focus();
				}
			}
		}
		
		if (opts.tree){
			$(opts.tree).tree({
				url: opts.treeUrl,
				onClick: function(node){
					$(target).datagrid('load');
				},
				onDrop: function(dest,source,point){
					var targetId = $(this).tree('getNode', dest).id;
					$.ajax({
						url: opts.treeDndUrl,
						type:'post',
						data:{
							id:source.id,
							targetId:targetId,
							point:point
						},
						dataType:'json',
						success:function(){
							$(target).datagrid('load');
						}
					});
				}
			});
		}
	}
	
	$.fn.edatagrid = function(options, param){
		if (typeof options == 'string'){
			var method = $.fn.edatagrid.methods[options];
			if (method){
				return method(this, param);
			} else {
				return this.datagrid(options, param);
			}
		}
		
		options = options || {};
		return this.each(function(){
			var state = $.data(this, 'edatagrid');
			if (state){
				$.extend(state.options, options);
			} else {
				$.data(this, 'edatagrid', {
					options: $.extend({}, $.fn.edatagrid.defaults, $.fn.edatagrid.parseOptions(this), options)
				});
			}
			buildGrid(this);
		});
	};
	
	$.fn.edatagrid.parseOptions = function(target){
		return $.extend({}, $.fn.datagrid.parseOptions(target), {
		});
	};
	
	$.fn.edatagrid.methods = {
		options: function(jq){
			var opts = $.data(jq[0], 'edatagrid').options;
			return opts;
		},
		enableEditing: function(jq){
			return jq.each(function(){
				var opts = $.data(this, 'edatagrid').options;
				opts.editing = true;
			});
		},
		disableEditing: function(jq){
			return jq.each(function(){
				var opts = $.data(this, 'edatagrid').options;
				opts.editing = false;
			});
		},
		editRow: function(jq, index){
			return jq.each(function(){
				var dg = $(this);
				var opts = $.data(this, 'edatagrid').options;
				var editIndex = opts.editIndex;
				if (editIndex != index){
					if (dg.datagrid('validateRow', editIndex)){
						if (editIndex>=0){
							if (opts.onBeforeSave.call(this, editIndex) == false) {
								setTimeout(function(){
									dg.datagrid('selectRow', editIndex);
								},0);
								return;
							}
						}
						dg.datagrid('endEdit', editIndex);
						dg.datagrid('beginEdit', index);
						opts.editIndex = index;
						var rows = dg.datagrid('getRows');
						opts.onEdit.call(this, index, rows[index]);
					} else {
						setTimeout(function(){
							dg.datagrid('selectRow', editIndex);
						}, 0);
					}
				}
			});
		},
		addRow: function(jq){
			return jq.each(function(){
				var dg = $(this);
				var opts = $.data(this, 'edatagrid').options;
				if (opts.editIndex >= 0){
					if (!dg.datagrid('validateRow', opts.editIndex)){
						dg.datagrid('selectRow', opts.editIndex);
						return;
					}
					if (opts.onBeforeSave.call(this, opts.editIndex) == false){
						setTimeout(function(){
							dg.datagrid('selectRow', opts.editIndex);
						},0);
						return;
					}
					dg.datagrid('endEdit', opts.editIndex);
				}
				dg.datagrid('appendRow', {isNewRecord:true});
				var rows = dg.datagrid('getRows');
				opts.editIndex = rows.length - 1;
				dg.datagrid('beginEdit', opts.editIndex);
				dg.datagrid('selectRow', opts.editIndex);
				
				if (opts.tree){
					var node = $(opts.tree).tree('getSelected');
					rows[opts.editIndex][opts.treeParentField] = (node ? node.id : 0);
				}
				
				opts.onAdd.call(this, opts.editIndex, rows[opts.editIndex]);
			});
		},
		saveRow: function(jq){
			return jq.each(function(){
				var dg = $(this);
				var opts = $.data(this, 'edatagrid').options;
				if (opts.onBeforeSave.call(this, opts.editIndex) == false) {
					setTimeout(function(){
						dg.datagrid('selectRow', opts.editIndex);
					},0);
					return;
				}
				$(this).datagrid('endEdit', opts.editIndex);
			});
		},
		cancelRow: function(jq){
			return jq.each(function(){
				var index = $(this).edatagrid('options').editIndex;
				$(this).datagrid('cancelEdit', index);
			});
		},
		destroyRow: function(jq){
			return jq.each(function(){
				var dg = $(this);
				var opts = $.data(this, 'edatagrid').options;
				var row = dg.datagrid('getSelected');
				if (!row){
					$.messager.show({
						title: opts.destroyMsg.norecord.title,
						msg: opts.destroyMsg.norecord.msg
					});
					return;
				}
				$.messager.confirm(opts.destroyMsg.confirm.title,opts.destroyMsg.confirm.msg,function(r){
					if (r){
						var index = dg.datagrid('getRowIndex', row);
						if (row.isNewRecord){
							dg.datagrid('cancelEdit', index);
						} else {
							if (opts.destroyUrl){
								$.delete_(opts.destroyUrl+'/'+row.id, {id:row.id}, function(result){
									if (result.success){
										if (opts.tree){
											dg.datagrid('reload');
											var t = $(opts.tree);
											var node = t.tree('find', row.id);
											if (node){
												t.tree('remove', node.target);
											}
										} else {
											dg.datagrid('cancelEdit', index);
											dg.datagrid('deleteRow', index);
										}
										opts.onDestroy.call(dg[0], index, row);
										$.messager.show({
											title   : '<span class="green">操作成功</span>',
											msg     : result.msg || '数据删除成功',
											timeout : 3000,
											showType: 'fade'
										});
									}else{
										$.messager.show({
											title   : '<span class="red">操作失败</span>',
											msg     : result.msg || '数据删除失败',
											timeout : 3000,
											showType: 'fade'
										});
									}
								},'json');
							} else {
								dg.datagrid('cancelEdit', index);
								dg.datagrid('deleteRow', index);
							}
						}
					}
				});
			});
		}
	};
	
	$.fn.edatagrid.defaults = $.extend({}, $.fn.datagrid.defaults, {
		editing: true,
		editIndex: -1,
		destroyMsg:{
			norecord:{
				title:'警告',
				msg:'没有选择记录'
			},
			confirm:{
				title:'确认',
				msg:'你确认要删除该记录？'
			}
		},
		destroyConfirmTitle: '确认',
		destroyConfirmMsg: '你确认要删除该记录？',
		
		url: null,	// return the datagrid data
		saveUrl: null,	// return the added row
		updateUrl: null,	// return the updated row
		destroyUrl: null,	// return {success:true}
		
		tree: null,		// the tree selector
		treeUrl: null,	// return tree data
		treeDndUrl: null,	// to process the drag and drop operation, return {success:true}
		treeTextField: 'name',
		treeParentField: 'parentId',
		
		onAdd: function(index, row){},
		onEdit: function(index, row){},
		onBeforeSave: function(index){},
		onSave: function(index, row){
			$(this).edatagrid('reload');
		},
		onDestroy: function(index, row){}
	});
})(jQuery);