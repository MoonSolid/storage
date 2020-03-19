DaoInvocationHandler 클래스생성 (Invocation 구현체)

DataLoaderListener 에서 Dao객체를 DaoInvocationHandler 를 통해 생성



```java
LessonDao lessonDao = (LessonDao) Proxy.newProxyInstance(//
          this.getClass().getClassLoader(), //
          new Class[] {LessonDao.class}, daoInvocationHandler);
```



 팩토리메서드를 적용하기위해 MybatisDaoFactory클래스 추가

```java
DaoInvocationHandler daoInvocationHandler;

  public MybatisDaoFactory(SqlSessionFactory sqlSessionFactory) {
    daoInvocationHandler = new DaoInvocationHandler(sqlSessionFactory);
  }

  @SuppressWarnings("unchecked")
  public <T> T createDao(Class<T> daoInterface) { //제네릭을 적용해서 리턴타입에 따라서
    return (T) Proxy.newProxyInstance(//          // 해당 Dao를 넘겨준다
        this.getClass().getClassLoader(), //
        new Class[] {daoInterface}, //
        daoInvocationHandler);

  }
```



MybatisDaoFactory적용후 



```java
LessonDao lessonDao = daoFactory.createDao(LessonDao.class); 
//메서드를 통해 Dao를 받는다  
//제네릭을 적용해서 형변환할 필요가 없다
```



MybatisDaoFactory 에서 DaoInvocationHandler 를 InvocationHandler 로 변경후

DaoInvocationHandler의 메서드를 가져와서 람다로 바꿈

DaoInvocationHandler 클래스 삭제

서버 45_2 README



명령어 bitcamp://localhost/board/list

BoardServiceImpl 에서  BoardDao 대신 SqlSessionFactory를 사용

DataLoaderListener에서 서비스객체를 준비하는 맵에 BoardDao 대신 sqlSessionFactory 사용