# boot-tools
result-spring-boot-starter

通过注解统一包装格式化控制器返回值

quick start:

1、在你得springboot项目pom里添加依赖
```
   <dependency>
      <groupId>com.result</groupId>
      <artifactId>result-spring-boot-starter</artifactId>
      <version>1.0-SNAPSHOT</version>
   </dependency>

   <dependency>
      <groupId>com.alibaba</groupId>
      <artifactId>fastjson</artifactId>
      <version>1.2.46</version>
      <optional>true</optional>
   </dependency>
```    
2、在你得控制器controller得方法上添加注解@ResponseResult

```
    @ResponseResult
    @RequestMapping("/s")
    public Object get(){
        return "sss";
    }
```    
    
返回值演示：

    返回结果
 
    {
        "code": 200,
        "data": "sss",
        "msg": "成功"
    }

