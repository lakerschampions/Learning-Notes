/*线性结构的特点：数据元素之间存在一对一的线性关系。数组、队列、链表、栈
	线性结构有两种不同的存储结构，顺序存储结构和链式存储结构。
	顺序存储的线性表称为顺序表，顺序表中的存储元素（地址）是连续的
	链式存储的线性表称为链表，存储元素不一定是连续的，元素节点存放元素以及相邻元素的地址信息。
	非线性结构包括：二维数组，多位数组，广义表，树、图结构。*/

public class SparseArray{
/*当一个数组大部分元素为0或者同一个值时，可以使用洗漱数组来保存该数组。
 * 处理方法：记录数组一共有几行几列，有多少个不同的值。把具有不同值的元素行列及值记录在一个小规模的数组中，从而缩小程序规模。
 */
	public static void main(String[] args) {
		//二维数组-》稀疏数组
		//创建一个原始的二维数组11*11。0表示没有棋子，1表示黑子，2表示篮子
		int chessArr1[][] = new int[11][11];
		chessArr1[1][2] = 1;
		chessArr1[2][3] = 2;
		System.out.println("原始的二维数组：");
		for (int[] row : chessArr1) {
			for(int data : row) {
				System.out.printf("%d\t",data);
			}
			System.out.println();
		}
		int sum = 0;
		for (int i = 0; i < 11; i++) {
			for(int j = 0; j < 11; j++) {
				if(chessArr1[i][j] != 0) {
					sum++;
				}
			}
		}
		
		int sparseArr[][] = new int[sum+1][3];
		sparseArr[0][0] = 11;
		sparseArr[0][1] = 11;
		sparseArr[0][2] = sum;
		
		int count = 0;//count用于记录是第几个非0数据
		for (int i = 0; i < 11; i++) {
			for(int j = 0; j < 11; j++) {
				if(chessArr1[i][j] != 0) {
					count++;
					sparseArr[count][0] = i;
					sparseArr[count][1] = j;
					sparseArr[count][2] = chessArr1[i][j];
				}
			}
		}
		//输出稀疏数组
		System.out.println("稀疏数组：");
		for(int i = 0; i < sparseArr.length; i++) {
			System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
		}
		System.out.println();
		
		//稀疏数组-》二维数组
		int chessArr2[][ ] = new int[sparseArr[0][0]][sparseArr[0][1]];
		System.out.println("恢复后的二维数组：");
		
		for(int i = 1; i < sparseArr.length; i++ ) {
			chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
		}
		
		for (int[] row : chessArr2) {
			for(int data : row) {
				System.out.printf("%d\t",data);
			}
			System.out.println();
		}
	}

}
