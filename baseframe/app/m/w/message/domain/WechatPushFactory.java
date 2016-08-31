package m.w.message.domain;

import java.util.List;


public class WechatPushFactory {
	/**
	 * 初始化对应模板类型实例
	 * @param className 模板类型路径
	 * @param pushBatch 批次对象
	 * @param templateid 模板id
	 * @param pushList 推送内容, 普通方式时内容为 身份证号|名字, 文件上传方式时为身份证号|名字|...完整内容字符串
	 * @param initType 1为普通方式, 2为文件上传
	 * @return 对应模板类型对象
	 * @throws Exception
	 */
	public static Pushable getInstance(String className,PushBatch pushBatch, String templateid, List<String> pushList, String initType)
			throws Exception {
		Pushable p = null;
		p = (Pushable) Class.forName(className)
				.getConstructor(PushBatch.class, String.class, List.class, String.class).newInstance(pushBatch, templateid, pushList, initType);
		return p;
	}
}
