package m.w.sys.domain;

import java.io.Serializable;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Prev;
import org.nutz.dao.entity.annotation.SQL;
import org.nutz.dao.entity.annotation.Table;

import m.w.core.dao.IdEntity;
import m.w.sys.util.WrapSupport;

@Table("Sys_DictItem")
public class DictItem extends WrapSupport implements Serializable, IdEntity, Comparable<DictItem> {
	private static final long serialVersionUID = 3870667342171505643L;
	
    @Id(auto=false)
    @Column
    @Prev(@SQL("select seq_dicitem.nextval from dual"))
	private Long id;

    /**
     * 字典类型id
     */
    @Column
    private Long typeId;
    
	@Column
	@ColDefine(notNull = true, type = ColType.VARCHAR, width = 200)
	private String text;
	
	@Column
	private Integer orders;
	
	@Column
	@ColDefine(type = ColType.VARCHAR, width = 200)
	private String notes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Integer getOrders() {
		return orders;
	}

	public void setOrders(Integer orders) {
		this.orders = orders;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public int compareTo(DictItem o) {
		if(typeId != o.typeId){
			return (int)(typeId - typeId);
		}else{
			return orders - o.orders;
		}
	}

}
