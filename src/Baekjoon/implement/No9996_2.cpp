#include <bits/stdc++.h>
using namespace std;

int n;
string s, ori_s, pre, suf; // pre = prefix, suf = suffix

int main(){
	
	cin >> n;
	cin >> ori_s; // ���� �Է� 
	int pos = ori_s.find('*'); // ���ڿ����� *�� index ��ȯ 
	pre = ori_s.substr(0, pos); // 0������ *��ġ ������ �����ϴ� ��
	suf = ori_s.substr(pos + 1); // *��ġ �������� ���������� �����ϴ� �� : ������ ��ұ��� ������ ��� �� ��° ���� ���� ����
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
