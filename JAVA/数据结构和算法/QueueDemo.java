import java.util.Scanner;

//队列是一个有序列表，可以用数组或是链表来实现，遵循先入先出原则。
public class QueueDemo {
		public static void main(String[] args) {
			ArrayQueue aq = new ArrayQueue(3);
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

//使用数组模拟队列
class ArrayQueue{
	private int maxSize;//最大容量
	private int front;
	private int rear;
	private int[] arr;
	
	//创建队列的构造器
	public ArrayQueue(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
		front = -1;//指向队列头的前一个位置
		rear = -1;//指向队列尾
	}
	public boolean isFull() {
		return rear == maxSize - 1;
	}
	
	public boolean isEmpty() {
		return rear == front;
	}
	
	public void addQueue(int n) {
		if(isFull()) {
			System.out.println("队列已满");
			return;
		}
		rear++;
		arr[rear] = n;
	}
	
	public int getQueue() {
		if(isEmpty()) {
			throw new RuntimeException("队列空");
		}
		front++;
		return arr[front];
	}
	
	public void showQueue() {
		if (isEmpty()) {
			System.out.println("队列为空");
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d]=%d\n", i,arr[i]);
		}
	}
	
	public int headQueue() {
		if(isEmpty()) {
			throw new RuntimeException("队列空");
		}
		return arr[front+1];
	}
}

