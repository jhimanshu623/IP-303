class LRUCache {
public:
    class Node
    {
        public:
            int key=-1;
            int val=-1;
            Node* prev;
            Node* next;
            
            Node(int key,int val,Node* prev,Node* next)
            {
                this->key=key;
                this->val=val;
                this->prev=prev;
                this->next=next;
            }
            Node(Node* prev,Node* next)
            {
                this->prev=prev;
                this->next=next;
            }
    };
    Node* head;
    Node* tail;
    int size;
    int cap;
    unordered_map<int,Node*> map1;
    
    void remove(Node* temp)
    {
        Node* tempp1=temp->next;
        Node* tempm1=temp->prev;
        tempm1->next=tempp1;
        tempp1->prev=tempm1;
        temp->next=nullptr;
        temp->prev=nullptr;
        size--;
    }
    
    void add(Node* temp)
    {
        Node* tempm1=tail->prev;
        tempm1->next=temp;
        tail->prev=temp;
        temp->prev=tempm1;
        temp->next=tail;
        size++;
    }
    
    LRUCache(int capacity) {
        cap=capacity;
        size=0;
        head=new Node(nullptr,nullptr);
        tail=new Node(nullptr,nullptr);
        head->next=tail;
        tail->prev=head;
    }
    
    int get(int key) {
        if(map1.count(key)==0)
            return -1;
        else
        {
            Node* temp=map1[key];
            remove(temp);
            add(temp);
            return temp->val;
        }
    }
    
    void put(int key, int value) {
        
        if(map1.count(key)!=0)
        {
            Node* temp=map1[key];
            temp->val=value;
            remove(temp);
            add(temp);
        }
        else
        {
            if(size<cap)
            {
                Node* temp=new Node(key,value,nullptr,nullptr);
                map1[key]=temp;
                add(temp);
            }
            else
            {
                Node* rn=head->next;
                remove(rn);
                map1.erase(rn->key);
                delete(rn);
                
                Node* temp=new Node(key,value,nullptr,nullptr);
                map1[key]=temp;
                add(temp);
            }
        }
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */