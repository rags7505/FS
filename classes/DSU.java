package classes;

public class DSU{
    public int p[];
    public DSU(int n){
        p=new int[n];
        for(int i=0;i<n;i++){
            p[i]=i;
        }
    }
    public int find(int x){
        if(p[x]!=x){
            p[x]= find(p[x]);
        }
        return p[x];
    }
    public void union(int a,int b){
        int x=find(a);
        int y=find(b);
        if(x!=y){
            p[y] = x;
        }
    }
}