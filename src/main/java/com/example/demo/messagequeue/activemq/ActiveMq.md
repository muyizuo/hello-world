### ActiveMq
#### 1. windows下的安装与启动
1. 下载ActiveMq的zip压缩包，解压即可。
2. 若是64位的系统，在ActiveMq下 `bin\win64` 目录中找到bat文件，如 `D:\activemq\bin\win64\activemq.bat` 。
   若是32位的系统，在ActiveMq下 `bin\win32` 目录中找到bat文件，如 `D:\activemq\bin\win32\activemq.bat` 。
3. 登录ActiveMq管理页面，默认地址是 `http://127.0.0.1:8161/` ，
   默认用户名密码： `admin/admin` 。
   
#### 2. 设置登录的用户名密码
1.安装目录下 `conf\jetty.xml` 。
`<property name="authenticate" value="true" />` ，true：需要认证； false：不需要认证。

```
<bean id="securityConstraint" class="org.eclipse.jetty.util.security.Constraint">
        <property name="name" value="BASIC" />
        <property name="roles" value="user,admin" />
        <!-- set authenticate=false to disable login -->
        <property name="authenticate" value="true" />
</bean>
```
2.安装目录下 `conf\jetty-realm.properties` 。
```
# Defines users that can access the web (console, demo, etc.)
# username: password [,rolename ...]
admin: admin, admin
user: user, user
```
3.重启ActiveMQ验证是否需要认证 重启activemq后，访问： `http://127.0.0.1:8161/admin/` ，
   弹出http基本认证框，这时候认证生效。
   
#### 3. 设置连接的用户名密码
1. 安装目录下 `conf/activemq.xml` 。添加如下内容：
```
<plugins>
    <simpleAuthenticationPlugin>
        <users>
            <authenticationUser username="zhangsan" password="123" groups="users,admins"/>
        </users>
    </simpleAuthenticationPlugin>
</plugins>
```
注意添加的位置在 `</broker>` 之上。
