@echo off
@echo 正在处理js文件
del /F /Q ..\WebContent\js\_pack\*
for /f %%i in (list.txt) do type %%i >> ..\WebContent\js\_pack\pack-all.js
java -jar ..\WebContent\WEB-INF\lib\yuicompressor-2.4.7.jar --type js --charset utf-8 ..\WebContent\js\_pack\pack-all.js -o ..\WebContent\js\_pack\pack-all-min.js

copy ..\WebContent\js\_pack\pack-all-min.js ..\WebContent\js\_pack\_pack-all-min.js
gzip -9 ..\WebContent\js\_pack\pack-all-min.js
move ..\WebContent\js\_pack\_pack-all-min.js ..\WebContent\js\_pack\pack-all-min.js
move ..\WebContent\js\_pack\pack-all-min.js.gz ..\WebContent\js\_pack\pack-all-min.gzjs


@echo 正在处理css文件
java -jar ..\WebContent\WEB-INF\lib\yuicompressor-2.4.7.jar --type css --charset utf-8 ..\WebContent\js\easyui\themes\default\easyui.css -o ..\WebContent\js\easyui\themes\default\easyui.min.css
java -jar ..\WebContent\WEB-INF\lib\yuicompressor-2.4.7.jar --type css --charset utf-8 ..\WebContent\js\easyui\themes\icon.css -o ..\WebContent\js\easyui\themes\icon.min.css
java -jar ..\WebContent\WEB-INF\lib\yuicompressor-2.4.7.jar --type css --charset utf-8 ..\WebContent\js\kindeditor\themes\default\default.css -o ..\WebContent\js\kindeditor\themes\default\default.min.css
java -jar ..\WebContent\WEB-INF\lib\yuicompressor-2.4.7.jar --type css --charset utf-8 ..\WebContent\css\main.css -o ..\WebContent\css\main.min.css
java -jar ..\WebContent\WEB-INF\lib\yuicompressor-2.4.7.jar --type css --charset utf-8 ..\WebContent\css\icon.css -o ..\WebContent\css\icon.min.css

copy ..\WebContent\js\easyui\themes\default\easyui.min.css ..\WebContent\js\easyui\themes\default\_easyui.min.css
copy ..\WebContent\js\easyui\themes\icon.min.css ..\WebContent\js\easyui\themes\_icon.min.css
copy ..\WebContent\js\kindeditor\themes\default\default.min.css ..\WebContent\js\kindeditor\themes\default\_default.min.css
copy ..\WebContent\css\main.min.css ..\WebContent\css\_main.min.css
copy ..\WebContent\css\icon.min.css ..\WebContent\css\_icon.min.css

gzip -9 ..\WebContent\js\easyui\themes\default\easyui.min.css
gzip -9 ..\WebContent\js\easyui\themes\icon.min.css
gzip -9 ..\WebContent\js\kindeditor\themes\default\default.min.css
gzip -9 ..\WebContent\css\main.min.css
gzip -9 ..\WebContent\css\icon.min.css

move ..\WebContent\js\easyui\themes\default\_easyui.min.css ..\WebContent\js\easyui\themes\default\easyui.min.css
move ..\WebContent\js\easyui\themes\_icon.min.css ..\WebContent\js\easyui\themes\icon.min.css
move ..\WebContent\js\kindeditor\themes\default\_default.min.css ..\WebContent\js\kindeditor\themes\default\default.min.css
move ..\WebContent\css\_main.min.css ..\WebContent\css\main.min.css
move ..\WebContent\css\_icon.min.css ..\WebContent\css\icon.min.css

move ..\WebContent\js\easyui\themes\default\easyui.min.css.gz ..\WebContent\js\easyui\themes\default\easyui.min.gzcss
move ..\WebContent\js\easyui\themes\icon.min.css.gz ..\WebContent\js\easyui\themes\icon.min.gzcss
move ..\WebContent\js\kindeditor\themes\default\default.min.css.gz ..\WebContent\js\kindeditor\themes\default\default.min.gzcss
move ..\WebContent\css\main.min.css.gz ..\WebContent\css\main.min.gzcss
move ..\WebContent\css\icon.min.css.gz ..\WebContent\css\icon.min.gzcss

@echo 处理文件完毕
