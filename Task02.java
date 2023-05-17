package Homework_Java_5_Mitrofanov_Filipp_4335;

public class Task02 {
    public static void seedUp(int [] heap, int v, int pos)
    {
        int tmp,curr=pos/2;
        heap[pos]=v;
        
        while(true)
        {
           if (heap[curr]>=v) 
           {
              return;
           }
           else
           {
               tmp=heap[curr];
               heap[curr]=heap[pos];
               heap[pos]=tmp;
               pos=curr;
               curr=curr/2;
               if (curr==0) return;
           }
        }
    }
    
    public static void seedDown(int [] heap, int last)
    {
        int curr,tmp,rr,ll,max;
        
        tmp=heap[1];
        heap[1]=heap[last];
        heap[last]=tmp;
 
        curr=1;
        while(true)
        {
            ll=2*curr;
            rr=ll+1;
 
            if ((ll>last-1) && (rr>last-1)) return;
            
            if (rr>last-1)
            {
                if (heap[ll]>heap[curr])
                {
                    tmp=heap[ll];
                    heap[ll]=heap[curr];
                    heap[curr]=tmp;
                    curr=ll;
                    continue;
                }
                return;
            }
 
            max=Math.max(heap[ll],heap[rr]);
 
            if (heap[curr]<max)
            {
                if (max==heap[ll])
                {
                    tmp=heap[ll];
                    heap[ll]=heap[curr];
                    heap[curr]=tmp;
                    curr=ll;
                    continue;
                }
                else
                {
                    tmp=heap[rr];
                    heap[rr]=heap[curr];
                    heap[curr]=tmp;
                    curr=rr;
                    continue;
                }
            }
            return;
        }
        
    }
    
    public static int [] makeHeap(int [] arr)
    {
        int n, i;
        n=arr.length;
        int [] heap = new int [n+1];
        
        heap[1]=arr[0];
        
        for (i=1; i<n; i++)
        {
            seedUp(heap,arr[i],i+1);
        }
        return heap;
 
    }
 
    public static void main(String[] args) {
        
        int [] arr={8,11,5,3,12,2,-6};
        int [] heap = makeHeap(arr);
        int size,i,n=arr.length;
        
        size=n;
        for (i=1; i<=n; i++)
        {
            seedDown(heap,size);
            size--;
        }
 
        for (i=1; i<heap.length; i++) System.out.print(heap[i]+" ");
        
    }
}
