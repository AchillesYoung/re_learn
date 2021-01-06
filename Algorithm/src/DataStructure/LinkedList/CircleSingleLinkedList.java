package DataStructure.LinkedList;

public class CircleSingleLinkedList {
    private ListNode first = null;
    public CircleSingleLinkedList(){

    }
    public void addListNode(int nums){
        if(nums < 1){
            System.out.println("nums的值不正确");
        }
        ListNode curListNode = null;
        for(int i = 1; i<=nums; ++i){
            ListNode ListNode = new ListNode(i);
            if( i == 1 ){
                this.first = ListNode;
                this.first.setNext(this.first);
                curListNode = this.first;
            }
            curListNode.setNext(ListNode);
            ListNode.setNext(this.first);
            curListNode = ListNode;
        }
    }
    public void showListNode(){
        if(this.first == null){
            System.out.println("none");
        }
        ListNode curListNode = this.first;
        while(true){
            System.out.printf("小孩的编号 %d \n", curListNode.value);
            if(curListNode.getNext() == this.first){
                return;
            }
            curListNode = curListNode.getNext();

        }
//        for(ListNode curListNode =this.first; curListNode !=this.first; curListNode = curListNode.next){
//            System.out.printf("小孩的编号 %d \n", curListNode.value);
//            System.out.println(curListNode);
//        }
    }

    /***
     * joshfu func
     */
    public void countListNode2(int countNum){
        while(this.first.next !=first){
            int j =0;
            for(j = 0;j<countNum-2; j++){
                first = this.first.next;
            }
            System.out.printf("小孩%d出圈\n", this.first.next.getValue());
            first.next = first.next.next;
            first= first.next;
        }
        System.out.printf("最后留在圈中的小孩编号%d \n", this.first.getValue());
    }

    public void countListNode(int countNum){
        if( this.first != null){
            ListNode help;
            /***
             * help循环到最后一个, first 前一个 ,有一个help在很省步奏
             */
            for(help = this.first; help.getNext() !=this.first; help = help.next){
            }
            int j;
            //help and first move together
            while(help !=this.first){
                for(j = 0;j<countNum -1; j++){
                    first = this.first.next;
                    help = help.next;
                }
                System.out.printf("小孩%d出圈\n", this.first.getValue());

                help.next = first.next;
                first = first.next;
            }
            System.out.printf("最后留在圈中的小孩编号%d \n", this.first.getValue());
        }else{
            System.out.println("参数输入有误， 请重新输入");
        }

    }
}
