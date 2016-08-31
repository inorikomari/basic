package m.w.sys.module;

import java.io.File;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import m.w.BasicModule;
import m.w.core.dto.DataGrid;
import m.w.core.dto.KeResult;
import m.w.core.dto.Result;
import m.w.core.util.Names;
import m.w.sys.domain.Atta;
import m.w.sys.domain.AttaType;
import m.w.sys.service.FileService;

import org.apache.commons.io.FilenameUtils;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Lang;
import org.nutz.lang.Streams;
import org.nutz.lang.Strings;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.POST;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.upload.TempFile;
import org.nutz.mvc.upload.UploadAdaptor;
import org.nutz.mvc.upload.UploadInfo;
import org.nutz.mvc.upload.Uploads;

@At("/sys/file")
@IocBean
public class FileModule extends BasicModule {
    @Inject
    private FileService fileService;
    
    @At("/attas/?")
    public Object attas(String attaIds){
    	if(!Strings.isBlank(attaIds)){
    		return fileService.attas(Lang.array2list(Strings.splitIgnoreBlank(attaIds, ","), Long.class));
    	}
    	return DataGrid.EMPTY; 
    }
    
    /**
     * 批量上传文件
     * 
     * @return
     */
    @At("/xupload/?")
    @POST
    @AdaptBy(type = UploadAdaptor.class, args = {"${app.root}/WEB-INF/tmp"})
    public Result xupload(AttaType type, @Param("..")Atta info, @Param("file") TempFile[] files) {
        try {
            return fileService.xupload(type, info, files, null);
        }
        catch (Exception e) {
            return Result.err(e.getMessage());
        }
    }

    /**
     * kindeditor上传文件
     * 
     * @return
     */
    @At("/upload/?")
    @POST
    @AdaptBy(type = UploadAdaptor.class, args = {"${app.root}/WEB-INF/tmp"})
    public KeResult upload(AttaType type, @Param("imgFile") TempFile file, @Param("fileDesc") String fileDesc) {
        return fileService.keupload(type, fileDesc, file, null);
    }
    
    /**
     * 获取当前上传进度信息
     * @param req
     * @return
     */
    @At
    public UploadInfo info(HttpServletRequest req){
        return Uploads.getInfo(req);
    }
    
    /**
     * 停止当前上传
     * @param req
     */
    @At
    public Result stop(HttpServletRequest req){
        try {
            Uploads.getInfo(req).stop = true;
        }
        catch (Exception e) {
            return Result.err(e.getMessage());
        }
        return Result.ok("上传停止成功！");
    }
    
    @At("/download/?")
    @Ok("raw:stream")
    public void download(Long id, HttpServletResponse rep){
        Atta a = fileService.fetch(id);
        File file = new File(FilenameUtils.concat(FileService.UPLOAD_ROOT_DIR, a.getFilePath()));
        if(a != null && file.exists()){
            InputStream fileIn = Streams.fileIn(file);
            rep.setContentType("application/x-msdownload");
            rep.setContentLength(a.getFileSize().intValue());
            String outFileName = Names.encodeFileName(a.getRawName());
            rep.setHeader("Content-Disposition", "attachment; filename=".concat(outFileName));
            int blockSize = 4096;
            int totalRead = 0;
            int readBytes = 0;
            byte b[] = new byte[blockSize];
            try {
                while((long)totalRead < a.getFileSize())
                {
                    readBytes = fileIn.read(b, 0, blockSize);
                    totalRead += readBytes;
                    rep.getOutputStream().write(b, 0, readBytes);
                }
                fileIn.close();
            } catch (Exception e) {
                //下载写入出错，不做处理
            }
        }
    }
    
    /**
     * 批量删除附件
     * @param attaIds
     * @return
     */
    @At
    @POST
    public Result xdelete(String attaIds) {
        return fileService.xdelete(attaIds, null, null);
    }

    /**
     * kindeditor上传文件
     * 
     * @return
     */
    @At
    @POST
    @AdaptBy(type = UploadAdaptor.class, args = {"${app.root}/WEB-INF/tmp"})
    public KeResult keupload(@Param("imgFile") TempFile file, @Param("fileDesc") String fileDesc) {
        AttaType type = AttaType.valueOf(param("dir"));
        System.out.println(fileDesc);
        return fileService.keupload(type, null, file, null);
    }
    
    /**
     * 浏览文件
     * 
     * @return
     */
    @At
    public Object kebrowse(HttpServletRequest request) {
        return fileService.kebrowse(request);
    }

    /**
     * 下载文件
     * 
     * @return
     */
    public Object download() {
        //
        return null;
    }


}
