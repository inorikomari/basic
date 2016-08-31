package m.w.message.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import m.w.message.util.PushDetails;

public class MeetingNotice implements Pushable {
	public static final String[] SUB_TITLE = { "title", "content", "time",
			"location", "address", "remark" };

	private PushBatch pushBatch;

	private List<String> pushList;

	private String templateid;
	
	/**
	 * 1:普通
	 * 2:文件
	 */
	private String initType;

	public MeetingNotice() {
		super();
	}

	public MeetingNotice(PushBatch pushBatch, String templateid,
			List<String> list, String initType) {
		super();
		this.pushBatch = pushBatch;
		this.pushList = list;
		this.templateid = templateid;
		this.initType = initType;
	}

	@Override
	public Map<String, Integer> generateData() {
		int success = 0, field = 0, bind = 0;
		if (!pushList.isEmpty()) {
			String contents = "";
			if("1".equals(initType))
				contents = format2String(pushBatch);
			for (String content : pushList) {
				content += contents;
				int i = PushDetails.toPush(content, SUB_TITLE, getTemplateid(),
						pushBatch.getId());
				if (0 == i) {
					success++;
				} else if (-1 == i) {
					field++;
				} else if (-2 == i) {
					bind++;
				}
			}
		}
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("total", pushList.size());
		map.put("success", success);
		map.put("field", field);
		map.put("bind", bind);
		return map;
	}

	@Override
	public String format2String(PushBatch pushBatch) {
		return pushBatch.getTitle() + "|" + pushBatch.getMsgContent() + "|"
				+ pushBatch.getMsgTime() + "|" + pushBatch.getMsgLocation()
				+ "|" + pushBatch.getMsgAddress() + "|"
				+ pushBatch.getMsgRemark();
	}

	public List<String> getPushList() {
		return pushList;
	}

	public void setPushList(List<String> pushList) {
		this.pushList = pushList;
	}

	public String getTemplateid() {
		return templateid;
	}

	public void setTemplateid(String templateid) {
		this.templateid = templateid;
	}

	public PushBatch getPushBatch() {
		return pushBatch;
	}

	public void setPushBatch(PushBatch pushBatch) {
		this.pushBatch = pushBatch;
	}

	public String getInitType() {
		return initType;
	}

	public void setInitType(String initType) {
		this.initType = initType;
	}

}
