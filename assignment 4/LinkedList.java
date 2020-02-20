import java.io.*; 
  
public class LinkedList{ 
  
    Node head; 
    
    static class Node { 
  
        double data;
         
        Node next; 
  
         
        Node(double d) 
        { 
            data = d; 
            next = null; 
        } 
    } 
      
     
    public static LinkedList insert(LinkedList list, double data) 
    { 
         
        Node new_node = new Node(data); 
        new_node.next = null; 
   
         
        if (list.head == null) { 
            list.head = new_node; 
        } 
        else { 
            
            Node last = list.head; 
            while (last.next != null) { 
                last = last.next; 
            } 
   
             
            last.next = new_node; 
        } 
   
         
        return list; 
    } 
      
     
    public static void printList(LinkedList list) 
    { 
        Node currNode = list.head; 
   
        System.out.print("Student GPA and Test Scores:  "); 
   
         
        while (currNode != null) { 
             
            System.out.print(currNode.data + " "); 
   
             
            currNode = currNode.next; 
        } 
          
        System.out.println(); 
    } 
  
    
    public static LinkedList deleteKey(LinkedList list, double key) 
    { 
     
        Node currNode = list.head, prev = null; 
  
       
        if (currNode != null && currNode.data == key) { 
            list.head = currNode.next;  
  
           
            System.out.println(key + " found and deleted"); 
  
            
            return list; 
        } 
  
        
        while (currNode != null && currNode.data != key) { 
            
            prev = currNode; 
            currNode = currNode.next; 
        } 
  
        
        if (currNode != null) { 


            prev.next = currNode.next; 
  
             
            System.out.println(key + " found and deleted"); 
        } 
  
        
        if (currNode == null) { 
             
            System.out.println(key + " not found"); 
        } 
  
         
        return list; 
    } 
  
        
    public static void main(String[] args) 
    { 
        
        LinkedList list = new LinkedList(); 
   
  
         
        list = insert(list, 3.87); 
        list = insert(list, 75.78); 
        list = insert(list, 100.03); 
        list = insert(list, 68.9); 
          
         
        printList(list); 
  
       
  
         
         
        deleteKey(list, 68.9); 
  
         
        printList(list); 
  
         
         
        deleteKey(list, 4); 
  
         
        printList(list); 
  
         
 
    } 
} 