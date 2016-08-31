package m.w.message.domain;

import java.util.List;
import java.util.Map;

public class SignNotice implements Pushable{
	
	public static final String[] SUB_TITLE = { "title", "content", "location", "time", "remark" };
	
	private List<String> pushList;
	
	private Long pid;
	
	public SignNotice() {
		super();
	}	
	
	public SignNotice(Long pid, List<String> list) {
		super();
		this.pushList = list;
		this.pid = pid;
	}

	@Override
	public Map<String, Integer> generateData() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String format2String(PushBatch pushBatch) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getPushList() {
		return pushList;
	}

	public void setPushList(List<String> list) {
		this.pushList = list;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

}
