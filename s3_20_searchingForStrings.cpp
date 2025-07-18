#include <iostream>
#include <string>
#include <unordered_set>
using namespace std;

static int count = 0;
static string n;
static vector<bool> used;
static unordered_set<string> combos;
static int nLen;

void findCombos(string curr) {
    if(curr.length() == nLen) {
        combos.insert(curr);
        return;
    }
    for(int i = 0; i < nLen; i++) {
        if(!used[i]) {
            used[i] = true;
            findCombos(curr + n[i]);
            used[i] = false;
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    
    getline(cin, n);
    string h;
    getline(cin, h);
    nLen = n.length();
    
    if(nLen > h.length()) {
        cout << 0 << endl;
        return 0;
    }
    
    used.resize(nLen);
    findCombos("");
    
    for(const string& s : combos) {
        if(h.find(s) != string::npos) {
            count++;
        }
    }
    cout << count << endl;
    
    return 0;
}
