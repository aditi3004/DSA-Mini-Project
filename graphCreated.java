
import java.util.*;

class Node{
	int No;
	String Name;
	Node next;
	char type;
	
	public Node(Node v) {
		this.No=v.No;
		this.Name=v.Name;
		this.next=null;
	}
	
	public Node(int No,String Name, char type) {
		this.No=No;
		this.Name=Name;
		this.type=type;
		this.next=null;
	}
}

class creation{
	Node c1,c2,c3,c4,c5,p1,p2,p3,p4,r1,r2,r3,r4;
	int src1,dest,actualDest;
	int adjmat[][];
	Scanner sc = new Scanner(System.in);
    Node head[] = new Node[13]; // number of heads for creating adjacency list
    int c=13;// number of vertices total in graph
    int e=13;// number of edges
    int i;
    int j;
    
	public void edgeCreate(Node u,Node v, int weight) {
			
			Node curr;
			Node new_node=new Node(v);
        	for(i=0;i<c;i++) {
        		if(head[i].No==u.No && head[i].type==u.type) {
        			curr=head[i];
        			while(curr.next!=null) {
        				curr=curr.next;
        			}
        			curr.next=new_node;
        		}
        	}
        }
	 
	
	public void dijkstra(int[][] adjacencyMatrix,Node src) {
		
		int v=adjacencyMatrix.length;
		boolean visited[]=new boolean[v];
		int distance[]=new int[v];
		//distance[0]=0;
		//first vertex ka distance would be 0 and baki saaare vertex ka distance would be infinity intially
		for(int i=0;i<13;i++) {
			distance[i]=Integer.MAX_VALUE;
			visited[i]=false;
		}
		
		int index=0;
		for(i=0;i<v;i++) {
			if((head[i].Name).equalsIgnoreCase(src.Name)) {
				index=i;
				break;
			}
		}
		distance[index]=0;
		
		for(int i=0;i<v-1;i++) {
			//find vertex with minimum distance from the starting vertex
			int minVertex=findMinVertex(distance,visited);
			visited[minVertex]=true;
			//explore the neighbors
			for(int j=0;j<v;j++) {
				if(adjacencyMatrix[minVertex][j]!=0 && !visited[j] && distance[minVertex]!=Integer.MAX_VALUE) {
					
					int newDist=distance[minVertex]+adjacencyMatrix[minVertex][j];
					if(newDist<distance[j]) {
						distance[j]=newDist;
						System.out.print(head[j].Name+"-->");
					}
				}
			}
		}
		
		//print vertex ka number and uska distance
		
			System.out.println("shortest distance from "+src.Name+" is "+distance[actualDest]+"km");
		
	}
	
	
	public int findMinVertex(int[]distance,boolean visited[]) {
		int minVertex=-1;
		for(int i=0;i<distance.length;i++) {
			if(!visited[i] && (minVertex==-1 || distance[i]<distance[minVertex])) {
				minVertex=i;
			}
		}
		return minVertex;
	}
    
	 public void displayList() {
	    	System.out.println("Adjacency list: ");
	        for (int i = 1; i <c; i++) {
	            Node curr = head[i];
	            System.out.print(curr.Name + " ");
	            while (curr.next != null) {
	                curr = curr.next;
	                System.out.print("--> " + curr.Name);
	            }
	            System.out.println();
	        }
	    }
	 
	 public void allCreate() {
		 adjmat=new int[13][13];
		 for(int i=0;i<13;i++) {
				for(int j=0;j<13;j++) {
					adjmat[i][j]=000;
				}
			}
		 c1=new Node(0,"pune",'c');
		 head[0]=c1;
		 c2=new Node(6,"bangalore",'c');
		 head[6]=c2;
		 c3=new Node(12,"delhi",'c');
		 head[12]=c3;
		 c4=new Node(8,"indore",'c');
		 head[8]=c4;
		 c5=new Node(3,"kashmir",'c');
		 head[3]=c5;
		 p1=new Node(1,"p1",'p');
		 head[1]=p1;
		 p2=new Node(11,"p2",'p');
		 head[11]=p2;
		 p3=new Node(7,"p3",'p');
		 head[7]=p3;
		 p4=new Node(4,"p4",'p');
		 head[4]=p4;
		 r1=new Node(2,"r1",'r');
		 head[2]=r1;
		 r2=new Node(10,"r2",'r');
		 head[10]=r2;
		 r3=new Node(9,"r3",'r');
		 head[9]=r3;
		 r4=new Node(5,"r4",'r');
		 head[5]=r4;
		 
		 
		 edgeCreate(c1,p1,500);
		 edgeCreate(p1,c1,500);
		 adjmat[0][1]=500;
		 adjmat[1][0]=500;
		 
		 edgeCreate(p1,r1,700);
		 edgeCreate(r1,p1,700);
		 adjmat[1][2]=700;
		 adjmat[2][1]=700;
		 
		 edgeCreate(r1,c3,200);
		 edgeCreate(c3,r1,200);
		 adjmat[2][12]=200;
		 adjmat[12][2]=200;
		 
		 edgeCreate(c3,p2,600);
		 edgeCreate(p2,c3,600);
		 adjmat[12][11]=600;
		 adjmat[11][12]=600;
		 
		 edgeCreate(p2,r2,150);
		 edgeCreate(r2,p2,150);
		 adjmat[11][10]=150;
		 adjmat[10][11]=150;
		 
		 edgeCreate(r2,r3,800);
		 edgeCreate(r3,r2,800);
		 adjmat[10][9]=800;
		 adjmat[9][10]=800;
		 
		 edgeCreate(c4,r3,475);
		 edgeCreate(r3,c4,475);
		 adjmat[8][9]=475;
		 adjmat[9][8]=475;
		 
		 edgeCreate(c4,p3,725);
		 edgeCreate(p3,c4,725);
		 adjmat[8][7]=725;
		 adjmat[7][8]=725;
		 
		 edgeCreate(c2,p3,650);
		 edgeCreate(p3,c2,650);
		 adjmat[6][7]=650;
		 adjmat[7][6]=650;
		 
		 edgeCreate(c2,p4,570);
		 edgeCreate(p4,c2,570);
		 adjmat[6][4]=570;
		 adjmat[4][6]=570;
		 
		 edgeCreate(p4,r4,315);
		 edgeCreate(r4,p4,315);
		 adjmat[4][5]=315;
		 adjmat[5][4]=315;
		 
		 edgeCreate(p4,c5,740);
		 edgeCreate(c5,p4,740);
		 adjmat[4][3]=740;
		 adjmat[3][4]=740;
		 
		 edgeCreate(r1,c5,100);
		 edgeCreate(c5,r1,100);
		 adjmat[2][3]=100;
		 adjmat[3][2]=100;
		 
		 
	 }
	 
	 public void shortestPath() {
		 	System.out.println("enter the source node: ");
			src1=sc.nextInt();
			System.out.println("enter the dest node: ");
			dest=sc.nextInt();
			
			if(src1==1) {
				if(dest==1) {
					actualDest=0;
				}
				else if(dest==2) {
					actualDest=6;
				}
				else if(dest==3) {
					actualDest=12;
				}
				else if(dest==4) {
					actualDest=8;
				}
				else if(dest==5) {
					actualDest=3;
				}
				dijkstra(adjmat,c1);
			}
			else if(src1==2){
				if(dest==1) {
					actualDest=0;
				}
				else if(dest==2) {
					actualDest=6;
				}
				else if(dest==3) {
					actualDest=12;
				}
				else if(dest==4) {
					actualDest=8;
				}
				else if(dest==5) {
					actualDest=3;
				}
				dijkstra(adjmat,c2);
			}
			else if(src1==3){
				if(dest==1) {
					actualDest=0;
				}
				else if(dest==2) {
					actualDest=6;
				}
				else if(dest==3) {
					actualDest=12;
				}
				else if(dest==4) {
					actualDest=8;
				}
				else if(dest==5) {
					actualDest=3;
				}
				dijkstra(adjmat,c3);
			}
			else if(src1==4){
				if(dest==1) {
					actualDest=0;
				}
				else if(dest==2) {
					actualDest=6;
				}
				else if(dest==3) {
					actualDest=12;
				}
				else if(dest==4) {
					actualDest=8;
				}
				else if(dest==5) {
					actualDest=3;
				}
				dijkstra(adjmat,c4);
			}
			else if(src1==5){
				if(dest==1) {
					actualDest=0;
				}
				else if(dest==2) {
					actualDest=6;
				}
				else if(dest==3) {
					actualDest=12;
				}
				else if(dest==4) {
					actualDest=8;
				}
				else if(dest==5) {
					actualDest=3;
				}
				dijkstra(adjmat,c5);
			}
	 }
}	
public class graphCreated {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("City 1: PUNE");
		System.out.println("City 2: BANGALORE");
		System.out.println("City 3: DELHI");
		System.out.println("City 4: INDORE");
		System.out.println("City 5: KASHMIR");
		
		
		creation cr=new creation();
		cr.allCreate();
		cr.displayList();
		cr.shortestPath();
		
		
		
	}

}
