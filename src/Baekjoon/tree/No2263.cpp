#include <bits/stdc++.h>
using namespace std;

int inorderArr[100000];
int postorderArr[100000];

void DFS(int start1, int end1, int start2, int end2){
	if (start1 > end1 || start2 > end2) return;
	
	int root = postorderArr[end2];
	int rootIndex = -1; // ���� ǥ����� ��Ʈ �ε��� 
	for(int i = start1; i <= end1; i++){
		if (inorderArr[i] == root){
			rootIndex = i;
			break;
		}
	}
	
	int leftCount = rootIndex - start1;
	
	// ���� Ž������ ��� (��Ʈ -> ���� -> ������) 
	cout << root << " ";
	DFS(start1, rootIndex - 1, start2, start2 + leftCount - 1); // ��Ʈ�� �������� ���� ������ ���� Ž�� (Inorder ���� �� Postorder ���� ����) 
	DFS(rootIndex + 1, end1, start2 + leftCount, end2 - 1); // // ��Ʈ�� �������� ������ ������ ���� Ž�� (Inorder ���� �� Postorder ���� ����) 

}

int main(){
	
	int n;
	cin >> n; // cin >> n >> '\n' (X)
	
	for(int i = 0; i < n; i++){
		cin >> inorderArr[i];
	}
	
	for(int i = 0; i < n; i++){
		cin >> postorderArr[i];
	} 	

	DFS(0,n-1,0,n-1);
	
	return 0;
}
