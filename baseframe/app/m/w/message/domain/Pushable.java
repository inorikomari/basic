package m.w.message.domain;

import java.util.Map;



public interface Pushable {
	public Map<String, Integer> generateData();
	
	public String format2String(PushBatch pushBatch);
}
