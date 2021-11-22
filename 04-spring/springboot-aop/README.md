PointCut表达式：

1）execution(* *(..))  
//表示匹配所有方法  
2）execution(public * com.mio4.demo.springbootaop.aop.ApiControllerAspect.*(..))  
//表示匹配com.mio4.demo.springbootaop.aop.ApiControllerAspect中所有的公有方法  
3）execution(* com.mio4.demo.springbootaop..*.*(..))  
//表示匹配com.mio4.demo.springbootaop包及其子包下的所有方法



说明

**JoinPoint**对象**封装了SpringAop中切面方法的信息**,在切面方法中添加**JoinPoint参数**,就可以获取到封装了该方法信息的**JoinPoint对象**

重要方法

| 方法                      | 说明                                                         |
| ------------------------- | ------------------------------------------------------------ |
| Signature getSignature(); | **获取封装了署名信息的对象,在该对象中可以获取到目标方法名,所属类的Class等信息** |
| Object[] getArgs();       | **获取连接点方法运行时的入参列表**                           |
| Object getTarget();       | **获取连接点所在的目标对象**                                 |
| Object getThis();         | **获取代理对象本身**                                         |


1. 说明

   ProceedingJoinPoint继承JoinPoint子接口，并且只能用于**@Around**的切面方法中

2. 新增方法

| 方法名                                         | 功能                             |
| ---------------------------------------------- | -------------------------------- |
| Object proceed() throws Throwable              | **执行目标方法**                 |
| Object proceed(Object[] var1) throws Throwable | **传入的新的参数去执行目标方法** |





使用场景：
1. HTTP访问打印日志
2. 接口鉴权 【HTTP请求校验Request】

TODO 打印日志 || 接口鉴权 















































 
