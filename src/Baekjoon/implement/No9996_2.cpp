#include <bits/stdc++.h>
using namespace std;

int n;
string s, ori_s, pre, suf; // pre = prefix, suf = suffix

int main(){
	
	cin >> n;
	cin >> ori_s; // 패턴 입력 
	int pos = ori_s.find('*'); // 문자열에서 *의 index 반환 
	pre = ori_s.substr(0, pos); // 0번부터 *위치 전까지 추출하는 것
	suf = ori_s.substr(pos + 1); // *위치 다음부터 마지막까지 추출하는 것 : 마지막 요소까지 추출할 경우 두 번째 인자 생략 가능
	for(int i = 0; i < n; i++){
		cin >> s;
		if(s.size() < pre.size() + suf.size()){
			cout << "NE" << "\n";
		} else {
			if(pre == s.substr(0, pre.size()) && suf == s.substr(s.size() - suf.size())) cout << "DA" << "\n";
			else cout << "NE" << "\n";
		}
	} 
	
	return 0;
}
