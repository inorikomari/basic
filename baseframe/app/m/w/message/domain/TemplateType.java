package m.w.message.domain;

import java.io.Serializable;

import m.w.core.dao.IdEntity;
import m.w.sys.util.WrapSupport;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;


@Table("mmsg_template_type")
public class TemplateType extends WrapSupport implements Serializable, IdEntity{

    /**
	 * 
	 */
	private static final long serialVersionUID = 8287985404220856206L;

	@Id(auto=false)
    @Column
    private Long id;
    
    /**
     * 标题
     */
    @Column
    @ColDefine(type = ColType.VARCHAR, width = 50)
    @Name
    private String text;
    
    /**
     * 类名
     */
    @Column
    @ColDefine(type = ColType.VARCHAR, width = 200)
    private String path;
    
    /**
     * 模板id
     */
    @Column
    @ColDefine(type = ColType.VARCHAR, width = 200)
    private String txid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getTxid() {
		return txid;
	}

	public void setTxid(String txid) {
		this.txid = txid;
	}
    
    
}
