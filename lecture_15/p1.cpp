#include<vector>
#include<unordered_map>
using namespace std;

class RandomizedSet {
public:
    /** Initialize your data structure here. */
    vector<int> arr;
    unordered_map<int,int> map;
    RandomizedSet() {
        this->arr.assign(0,0);
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    bool insert(int val) {
        if(map.count(val)==0){
            map[val]=arr.size();
            arr.push_back(val);
            return true;
        }
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    bool remove(int val) {
        if(map.count(val)==0)
            return false;
        int ridx=map[val];
        map[arr[arr.size()-1]]=ridx;
        arr[ridx]=arr[arr.size()-1];
        arr.pop_back();
        map.erase(val);
        return true;
    }
    
    /** Get a random element from the set. */
    int getRandom() {
        if(arr.size()==0)
            return -1;
        int ridx=rand() % arr.size();
        return arr[ridx];
    }
};
int main(int args,char** argv)
{
    return 0;
}