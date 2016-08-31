package m.w.message.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Files;
import org.nutz.lang.Times;
import org.nutz.mvc.Mvcs;
import org.nutz.mvc.upload.FieldMeta;
import org.nutz.mvc.upload.TempFile;

import m.w.core.service.WxIdService;
import m.w.message.domain.Employee;
import m.w.message.domain.PushBatch;

@IocBean(fields="dao")
public class EmployeeService extends WxIdService<Employee>{

	public List<String> getPushList(PushBatch pushBatch) {
		List<String> res = new ArrayList<String>();
		String ids = pushBatch.getGroups().replaceAll("DEPT-{1}[\\d]+,", "");
		ids = ids.replaceAll("DEPT-{1}[\\d]+", "");
		List<Employee> list = query(Cnd.where("id","IN",ids),null);
		for(Employee e:list)
			res.add(e.getCertNo()+"|"+e.getName()+"|");
		return res;
	}

	public List<String> getPushList(PushBatch pushBatch, TempFile temp) throws IOException {
		List<String> pushList = new ArrayList<String>();
		FieldMeta meta = temp.getMeta();
        File file = temp.getFile();
        BufferedReader reader = null;
    	try {
    		FileInputStream fis = new FileInputStream(file); 
    		InputStreamReader isr = new InputStreamReader(fis,"GBK");
    		reader = new BufferedReader(isr);
    		String tempString = null;
    		while ((tempString = reader.readLine()) != null) {
    			pushList.add(tempString);
    		}
    		
    		String extName = meta.getFileExtension();
            String rawName = meta.getFileLocalName();

            String filePath = FilenameUtils.concat(FilenameUtils.concat(rawName.substring(0,rawName.lastIndexOf(".")), Times.format(new SimpleDateFormat("yyyyMMdd"), new Date())), UUID.randomUUID().toString()+extName);

            File newFile = new File(Mvcs.getHttpSession().getServletContext().getRealPath("/upload/"), filePath);
            
            Files.copy(file, newFile);
    	} catch (IOException e) {
    		e.printStackTrace();
    	} finally {
    		if (reader != null) {
    			try {
    				reader.close();
    				file.deleteOnExit();
    				reader = null;
    			} catch (IOException e1) {
    				e1.printStackTrace();
    			}
    		}
    	}
		return pushList;
	}
	
}
