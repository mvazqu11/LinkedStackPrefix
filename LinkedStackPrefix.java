//import java.util.EmptyStackException;
public  class LinkedStackPrefix <T> implements IGenericStack2 <T>{
    
    
    private IGenericStack2 <Double> valueStack = new LinkedStackPrefix<Double>();
    private IGenericStack2 <Character> operatorStack = new LinkedStackPrefix<Character>();
    
    //1.) begin with your Node class 
    public class Node<T>{
        private T data;
        private Node <T> next;
        
        
        Node (T data){
            this.data=data;
            this.next=null;
        }
        Node (T data, Node <T> next){
            this.data=data;
            this.next=next;
            
        } 
        
    }//closes Node class
    
    //start putting properties
    private Node <T> top;
    
    
    
    //private T [] p;
    
    //constructor
    public LinkedStackPrefix(){
        this.top=null;
        
    }
    /* public LinkedStackPrefix(){
     this.p = new T[];  
     }*/
    public boolean isEmpty(){
        return this.top==null; 
    }
    
    public void push(T item){
        this.top= new Node(item, this.top); 
    }
    public T peek(){
        //the bottom one is for Linked Stack
        if(isEmpty()) throw new EmptyStackException("No hay nada todavia");
        //if(this.isEmpty()) throw new HelpfulEmptyStackException("Stack is empty terco");
        return this.top.data;
        
    }
    
    public T pop(){
        if(isEmpty()) 
            throw new EmptyStackException("Nada");
        T tmp = this.peek();
        this.top= this.top.next;
        return tmp;
        
    }
    public boolean solve(String prefixExpression){
        String  [] tokens = prefixExpression.split(" ");
        for(String token: tokens){
            if(isValue(token)){
                System.out.println(token + "is value");
                valueStack.push(Double.parseDouble(token));
            }
            else if(isOperator(token)){
                System.out.println(token + "is operator");
                operatorStack.push(token.charAt(0));
            }
            else
                throw new InvalidTokenException(token);
        }
        return true;            
    }  
    
    public  boolean isOperator(String s){
        return s.equals("*") || s.equals("+"); 
        
    }
    
    public boolean isValue(String str){
        return !isOperator(str);
//          double num=0.0;
//          if(!isOperator(str))
//               num= Integer.parseInt(str);
//          return num;
    }
    
}






