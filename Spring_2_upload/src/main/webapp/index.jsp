<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>Tittle</title>
</head>
<body>
<h2>文件上传</h2>
    <h3>跨服务器上传</h3>
        <form action="/user/fileupload3" method="post" enctype="multipart/form-data">
                选择文件： <input type="file" name="upload"/><br/>
                            <input type="submit" value="上传"/>
        </form>
    <h3>Springmvc文件上传</h3>
        <form action="/user/fileupload2" method="post" enctype="multipart/form-data">
            选择文件： <input type="file" name="upload"/><br/>
            <input type="submit" value="上传"/>
        </form>
</body>
</html>
