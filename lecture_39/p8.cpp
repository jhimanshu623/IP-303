bool Graph::isEulerianCycle()
{
    // list <int> :: iterator it; 
    // for(int i=0;i<V;i++) {
    //     cout<<i<<"->";
    //     for(auto it = adj[i].begin(); it != adj[i].end(); ++it) 
    //     {
    //         cout<<*it<<" ";
    //     }
    //     cout<<endl;
    // }
    int *in=new int[V]();
    int *ou=new int[V]();
    list<int> :: iterator it;
    for(int i=0;i<V;i++)
    {
        for(it=adj[i].begin(); it != adj[i].end() ;it++)
        {
            int nv=*it;
            ou[i]++;
            in[nv]++;
        }
    }
    
    for(int i=0;i<V;i++)
    {
        if(in[i]!=ou[i])
            return false;
    }
    return true;
}