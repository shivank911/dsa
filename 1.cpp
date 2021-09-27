#include<bits/stdc++.h>
#include<algorithm>
#include<vector>
#define ve vector<int>
#define pb push_back
#define endl "\n"
#define ll long long int
#define ld long double
#define ui unsigned int
#define ull unsigned ll
#define vll vector<ll>
#define vve vector < ve >
#define pii pair<int,int>
#define pll pair<long long, long long>
#define foi(n) for(ll i=0;i<n;i++)
#define foj(n) for(ll j=0;j<n;j++)
#define fok(n) for(ll k=0;k<n;k++)
#define pf                   push_front
#define popb                 pop_back
#define popf                 pop_front
#define hashmap              unordered_map
#define hashset              unordered_set
#define mod 1000000007
#define inf 1000000000000000001;
using namespace std;

struct node {
    int data;
    node* left;
    node* right;
};
node* newnode(int data) {

    node* nde = new node();
    nde->data = data;
    nde->left = NULL;
    nde->right = NULL;

    return nde;
}
node* construt(int arr[], int lo, int hi) {
    if (lo > hi)
        return NULL;
    int mid = (lo + hi) / 2;
    node* root = newnode(arr[mid]);
    root->left = construt(arr, lo, mid - 1);
    root->right = construt(arr, mid + 1, hi);
    return root;
}
void preOrder(node* nde)
{
    if (nde == NULL)
        return;
    cout << nde->data << " ";
    preOrder(nde->left);
    preOrder(nde->right);
}
int main()
{
    std::ios::sync_with_stdio(false);
#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    ll n;
    cin >> n;
    int arr[n];
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    int low = 0, hi = n - 1;
    node* root = construt(arr, 0, n - 1);
    if (n == 1) {
        cout << arr[0];
    }
    else
        preOrder(root);


    return 0;

}
