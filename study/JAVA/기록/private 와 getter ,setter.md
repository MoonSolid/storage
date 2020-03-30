private 와 getter ,setter 

```
public class study {
  public static void main(String[] args) {
    Account acc = new Account();
    acc.setAccNum("1234");
    System.out.println(acc.getAccNum());
    // getter , setter
  }
}
class Account{
  private String accNum;
  private String owner;
  private String passwd;
  
  public Account() {
    this.accNum = "1234";
    this.owner = "mkd";
    this.passwd = "1234";
  }
  
  
  public void setAccNum(String accNum) {
    this.accNum = accNum;
  }
  
  public String getAccNum() {
    return this.accNum;
  }
  
  
  
}   

```

