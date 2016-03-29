package rcpClient;


import java.io.IOException;
import java.util.Scanner;

public class ListDG {
    // 邻接表中表对应的链表的顶点
	
	public  String apply(char[] vexs,char[][] edges){
		  ListDG pG = new ListDG(vexs, edges);
	        pG.print();   // 打印图
	        pG.DFS();     // 深度优先遍历
	        pG.BFS();     // 广度优先遍历
	        return "sucess";
	}
   
	private class ENode{
		int ivex;
		ENode nextEdge;
	}
	
	private class VNode{
		char data;
		ENode firstEdge;
	}
	private VNode[] mVexs;
	 /*
	* 创建图(自己输入数据)
	*/
	public ListDG() {
	// 输入"顶点数"和"边数"
	System.out.printf("input vertex number: ");
	int vlen = readInt();
	System.out.printf("input edge number: ");
	int elen = readInt();
	if ( vlen < 1 || elen < 1 || (elen > (vlen*(vlen - 1)))) {
	System.out.printf("input error: invalid parameters!\n");
	return ;
	}
	// 初始化"顶点"
	mVexs = new VNode[vlen];
	for (int i = 0; i < mVexs.length; i++) {
	System.out.printf("vertex(%d): ", i);
	mVexs[i] = new VNode();
	mVexs[i].data = readChar();
	mVexs[i].firstEdge = null;
	}
	// 初始化"边"
	//mMatrix = new int[vlen][vlen];
	for (int i = 0; i < elen; i++) {
	// 读取边的起始顶点和结束顶点
	System.out.printf("edge(%d):", i);
	char c1 = readChar();
	char c2 = readChar();
	int p1 = getPosition(c1);
	int p2 = getPosition(c2);
	// 初始化node1
	ENode node1 = new ENode();
	node1.ivex = p2;
	// 将node1链接到"p1所在链表的末尾"
	if(mVexs[p1].firstEdge == null)
	mVexs[p1].firstEdge = node1;
	else
	linkLast(mVexs[p1].firstEdge, node1);
	}
	}
	 /*
	* 读取一个输入字符
	*/
	private char readChar() {
	char ch='0';
	do {
	try {
	ch = (char)System.in.read();
	} catch (IOException e) {
	e.printStackTrace();
	}
	} while(!((ch>='a'&&ch<='z') || (ch>='A'&&ch<='Z')));
	return ch;
	}
	/*
	* 读取一个输入字符
	*/
	private int readInt() {
	Scanner scanner = new Scanner(System.in);
	return scanner.nextInt();
	}
	
    /**用户已知的图
     * 
     * @param vexs
     * @param edges
     */

	public ListDG(char[] vexs,char[][] edges){
		int vlen=vexs.length;
		int elen=edges.length;
		
		mVexs=new VNode[vlen];
		for(int i=0;i< mVexs.length;i++){
			mVexs[i]=new VNode();
			mVexs[i].data=vexs[i];
			mVexs[i].firstEdge=null;	
		}
		
		for(int i=0;i<elen;i++){
			char c1=edges[i][0];
			char c2=edges[i][1];
			
			int p1=getPosition(edges[i][0]);
			int p2=getPosition(edges[i][1]);
			ENode node1=new ENode();
			node1.ivex=p2;
			
			if(mVexs[p1].firstEdge==null)
				mVexs[p1].firstEdge=node1;
			else
				linkLast(mVexs[p1].firstEdge,node1);	
		}
		
	}
	
	private void linkLast(ENode list,ENode node){
		ENode p=list;
		while(p.nextEdge!=null)
			p=p.nextEdge;
		p.nextEdge=node;
		
	}
	
	public void print(){
		System.out.printf("List Graph:\n");
		for(int i=0;i<mVexs.length;i++){
			System.out.printf("%d(%c):",i,mVexs[i].data);
			ENode node=mVexs[i].firstEdge;
			while(node!=null){
				System.out.printf("%d(%c) ",node.ivex,mVexs[node.ivex].data);
				node=node.nextEdge;
			}
			System.out.println();
			
		}
	}
	
	public void DFS(){
		boolean visited[]=new boolean[mVexs.length];
		for(int i=0;i<mVexs.length;i++){
			visited[i]=false;	
		}
		System.out.printf("DFS: ");
      for(int i=0;i<mVexs.length;i++){
    	  if(!visited[i]){
    		  DFS(i,visited);
    	  }
		
		}
      System.out.printf("\n");
	}
	
  private void DFS(int i,boolean[] visited){
	  visited[i]=true;
	  System.out.printf("%c ",mVexs[i].data );
	  ENode node=mVexs[i].firstEdge;
	  while(node!=null){
		  if(visited[node.ivex]==false){
			  DFS(node.ivex,visited);
		  }
			  node=node.nextEdge;
		  
		  
	  }
	  
  }
	
	public void BFS(){
		boolean visited[]=new boolean[mVexs.length];
		int [] queue=new int[mVexs.length];
		int head=0,rear=0;
		for(int i=0;i<mVexs.length;i++){
			visited[i]=false;	
		}

		System.out.printf("BFS: ");
		for(int i=0;i<mVexs.length;i++){
			if(visited[i]==false){
				visited[i]=true;
				System.out.printf("%c ",mVexs[i].data );
				queue[rear++]=i;
			}
			while(head!=rear){
			int	j=queue[head++];
			ENode node=mVexs[i].firstEdge;
			while(node!=null){
				int k=node.ivex;
				if(!visited[k]){
					visited[k]=true;
					System.out.printf("%c ", mVexs[k].data);
					queue[rear++]=k;
				}
				node=node.nextEdge;
			}
			
			}	
		}
		 System.out.printf("\n");
	}
	
	private int getPosition(char ch){
		  for(int i=0;i<mVexs.length;i++)
			  if(mVexs[i].data==ch)
				  return i;
		  return -1;
	  }
    public static void main(String[] args) {
    	 char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
   	    char[][] edges = new char[][]{
	   	  {'A', 'B'},
	   	  {'B', 'C'},
	   	  {'B', 'E'},
	   	  {'B', 'F'},
	   	  {'C', 'E'},
	   	  {'D', 'C'},
	   	  {'E', 'B'},
	   	  {'E', 'D'},
	   	  {'F', 'G'}};
        ListDG pG;
        // 自定义"图"(输入矩阵队列)
        //pG = new ListDG();
        // 采用已有的"图"
        pG = new ListDG(vexs, edges);
        pG.apply(vexs, edges);
       /* pG.print();   // 打印图
        pG.DFS();     // 深度优先遍历
        pG.BFS();     // 广度优先遍历
*/    }
}

