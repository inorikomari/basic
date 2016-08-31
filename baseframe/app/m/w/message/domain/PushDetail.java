package m.w.message.domain;

import java.io.Serializable;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Comment;
import org.nutz.dao.entity.annotation.Default;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Prev;
import org.nutz.dao.entity.annotation.SQL;
import org.nutz.dao.entity.annotation.Table;

import m.w.core.dao.IdEntity;
import m.w.sys.util.WrapSupport;

@Table("mmsg_push_detail")
public class PushDetail extends WrapSupport implements Serializable, IdEntity {
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 6529873756449153579L;

	@Id(auto=false)
    @Column
    @Prev(@SQL("select seq_pdetail.nextval from dual"))
    private Long id;
    
    @Column
    private Long pid;
    
    @Column
    @ColDefine(type = ColType.VARCHAR, width = 2000)
    @Comment("内容")
    private String content;
    
    /**
     * 明细条目状态
     * 0:待发送
     * 1:发送成功
     * 2:发送失败
     */
    @Column
    @Comment("状态")
    @Default("0")
    private Integer state;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
    
    
    
}
