# 项目介绍
这是一个学习PHP框架的项目，框架名称：[thinkPHP](https://www.thinkphp.cn/)。

# 环境配置
## wamp
安装集成环境wamp，下载链接[在这里](https://www.wampserver.com/en/)。

如果需要设置虚拟主机，需要在Windows的hosts文件中添加映射，下面是hosts的映射文件：
```txt
127.0.0.1		 localhost
```

## thinkphp安装
1. 首先需要安装composer包管理器，[官网](https://getcomposer.org/)在这里。
2. 安装完composer之后。使用命令行工具进入到需要安装think PHP的目录下面，然后执行如下命令：
```bash
create-project topthink/think [project_name]
```
# PHP操作MySQL
## 案例1
```php
<?php
/*
* Change the value of $password if you have set a password on the root userid
* Change NULL to port number to use DBMS other than the default using port 3306
*
*/
$user = 'root';
$password = 'root'; //To be completed if you have set a password to root
$database = 'test'; //To be completed to connect to a database. The database must exist.
$port = 3306; //NULL; //Default must be NULL to use default port
$mysqli = new mysqli('127.0.0.1', $user, $password, $database, $port);

if ($mysqli->connect_error) {
    die('Connect Error (' . $mysqli->connect_errno . ') '
            . $mysqli->connect_error);
}
echo '<p>Connection OK '. $mysqli->host_info.'</p>';
echo '<p>Server '.$mysqli->server_info.'</p>';
echo '<p>Initial charset: '.$mysqli->character_set_name().'</p>';

$sql = 'select * from users';
$result = $mysqli->query($sql);

if ($result->num_rows > 0) {
    while ($row = $result->fetch_assoc()) {
        echo $row['id'] . ' ' . $row['username'] . ' ' . $row['age'] . ' ' . $row['nickname'];
    }
}

$mysqli->close();
?>
```