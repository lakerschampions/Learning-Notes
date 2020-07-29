import java.util.Scanner;

/*环形队列
front的含义：指向队列的第一个元素，初始值是0。
rear的含义：指向队列的最后一个元素的后一个位置，预留一个位置，初始值是0。
当队列满时，条件是(rear+1)%maxsize==front
当队列为空时，rear==front
队列中有效的数据个数(rear+maxsize-front)%maxsize
*/
public class CircleQueueDemo{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircleArray aq = new CircleArray(4);
		char key = ' ';
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		while(loop) {
			System.out.println("s:显示队列");
			System.out.println("e:退出");
			System.out.println("a:添加数据");
			System.out.println("g:取出数据");
			System.out.println("h:查看队列头");
			key = scanner.next().charAt(0);
			switch(key) {
			case 's':
				aq.showQueue();
				break;
			case 'a':
				System.out.println("输出一个数");
				int value = scanner.nextInt();
				aq.addQueue(value);
				break;
			case 'g':
				try {
					int res = aq.getQueue();
					System.out.printf("取出的数据是%d\n",res);
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			    break;
			
			case 'h':
				try {
					int res = aq.headQueue();
					System.out.printf("队列头是%d\n",res);
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 'e':
				scanner.close();
				loop = false;
				break;
				
			default:
				break;				
		}
		}
		System.out.println("程序退出");
	}

}

class CircleArray{
	private int maxSize; 	//最大容量
	private int front;
	private int rear;
	private int[] arr;
	
	public CircleArray(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
	}
	
	public boolean isFull() {
		return (rear + 1) % maxSize  == front;
	}
	
	public boolean isEmpty() {
		return rear == front;
	}
	
	public void addQueue(int n) {
		if(isFull()) {
			System.out.println("队列已满");
			return;
		}
		arr[rear] = n;
		rear = (rear + 1) % maxSize;
	}
	
	public int getQueue() {
		if(isEmpty()) {
			throw new RuntimeException("队列空");
		}
		//1.先把front对应的值保存到一个临时变量
		//2.将front后移
		//3.将临时保存的变量返回
		int value = arr[front];
		front = (front + 1) % maxSize;
		return value;
	}
	
	public void showQueue() {
		if (isEmpty()) {
			System.out.println("队列为空");
			return;
		}
		//从front开始遍历，遍历多少个元素
		for (int i = front; i < front + size(); i++) {
			System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
		}
	}
	
	//求出当前队列有效数据
	public int size() {
		return (rear + maxSize- front) % maxSize;
	}
	
	public int headQueue() {
		if(isEmpty()) {
			throw new RuntimeException("队列空");
		}
		return arr[front];
	}
}
