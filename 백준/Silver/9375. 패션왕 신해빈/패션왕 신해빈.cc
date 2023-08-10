#include<bits/stdc++.h>
using namespace std; 

int T, N, ret;
map<string, int> mp;
string value, key;

int main() {
	
	cin >> T;
	
	while(T--){
		ret = 1;
		cin >> N;
		for(int i = 0; i < N; i++){
			cin >> value >> key;
			if(mp[key] == 0) mp[key] = 1;
			else mp[key] += 1;
		}
		
		for(auto it : mp) {
			ret *= (it.second + 1);
		}
		
		cout << ret - 1 << "\n";
		
		mp.clear();
	}
	
	return 0; 
}
