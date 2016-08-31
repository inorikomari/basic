package m.w.message.domain;

import java.util.List;
import java.util.Map;

public class AccountChangeNotice implements Pushable{
	
	public static final String[] SUB_TITLE = { "title", "productType", "name",
		"accountType", "account", "type", "number", "time", "remark" };
	
	private List<String> pushList;
	
	
	public AccountChangeNotice() {
		super();
	}	
	
	public AccountChangeNotice(List<String> list) {
		super();
		this.pushList = list;
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

	public List<String> getContent() {
		return pushList;
	}

	public void setContent(List<String> list) {
		this.pushList = list;
	}

}
