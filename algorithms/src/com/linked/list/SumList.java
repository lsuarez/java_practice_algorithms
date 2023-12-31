package com.linked.list;

public class SumList {
    static LinkedList result = new LinkedList();
    static int carry =0;
    public static void main(String[] args){
        LinkedList l1 = new LinkedList();
        l1.append(5);
        l1.append(1);
        l1.append(4);

        int size =l1.getSize();
        LinkedList l2 = new LinkedList();
        l2.append(1);
        l2.append(9);
        l2.append(5);
        l2.append(9);

        LinkedList result = numValues(l1, l2);

    }

    private static LinkedList numValues(LinkedList l1, LinkedList l2){
        if(l1 == null && l2 == null ){
            return null;
        }
        LinkedList result = new LinkedList();


        Node next1 = l1.head, next2 = l2.head;
        int carry =0, value=0;
        while(next1!= null && next2!= null) {
            value=next1.data+next2.data+carry;
            result.append(value % 10);
            if(value>=10)
                carry=1;
            else
                carry =0;
            next1=next1.next;
            next2=next2.next;
        }
        while(next1!=null){
            if(carry == 1) {
                result.append(next1.data + carry);
                carry =0;
            }else{
                result.append(next1.data);
            }
            next1=next1.next;
        }
        while(next2!=null){
            if(carry == 1) {
                result.append(next2.data+carry);
                carry =0;
            }else{
                result.append(next2.data);
            }
            next2=next2.next;
        }
        return result;
    }




}
