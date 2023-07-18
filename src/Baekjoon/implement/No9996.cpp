#include <bits/stdc++.h>
using namespace std;

int N, size1, size2;
string p, p1, p2, a;

int main(){
	
	cin >> N;
	cin >> p;
	
	for(int i = 0; i < p.size(); i++){
		if(p[i] == 42) {
			// 0 ~ i-1 ������ p1���� �Ҵ�
			p1 = p.substr(0, i); 
			// p[i+1] ���� ������ p2�� �Ҵ�
			p2 = p.substr(i+1, p.size() - i - 1);
		}
	}
	
	size1 = p1.size(); size2 = p2.size();
	
	for(int i = 0; i < N; i++){
		cin >> a;
		if (a.size() < size1 + size2) {
			cout << "NE" << "\n";
			continue;
		}
		
		if (a.substr(0, size1) != p1) {
			cout << "NE" << "\n";
			continue;
		}
		// �Է��� ���ڿ��� ���� ���ڿ����� ª�� ���, Out of Range ���� �߻�
		if (a.substr(a.size() - size2, size2) != p2) {
			cout << "NE" << "\n";
			continue;
		}
		
		cout << "DA" << "\n";
	}
	
	return 0;
}
