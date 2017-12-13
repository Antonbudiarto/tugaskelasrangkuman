package tugas_bt_sorting;

/**
 *
 * @author Fiki L
 */
public class Sort {
    void printArray(int arr[]){
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    public void selection(int data[]){
        for(int i = 0; i < data.length-1; i++){
            int min_idx = i;
            for(int j = i+1; j < data.length; j++)
                if(data[j] < data[min_idx])
                    min_idx = j;
            int t = data[min_idx];
            data[min_idx] = data[i];
            data[i] = t;
        }
    }
    public void insertion(int data[]){
        for(int i = 0; i<data.length; i++){
            int key = data[i];
            int j = i-1;
            while(j>=0 && data[j] > key){
                data[j+1] = data[j];
                j = j-1;
            }
            data[j+1] = key;
        }
    }
    public void bubble(int data[]){
        for(int i = 0; i < data.length-1; i++){
            for(int j = 0; j < data.length-i-1; j++)
                if(data[j] > data[j+1]){
                    int t = data[j];
                    data[j] = data[j+1];
                    data[j+1] = t;
                }
        }
    }
    //Program Java untuk Merge Sort
    //Menggabungkan dua subarray dari data [].
    //Subarray pertama adalah arr [l .. m]
    //Subarray kedua adalah arr [m + 1..r]
    public void merge(int data[],int l, int m, int r){
        //Temukan ukuran dua subarray yang akan digabungkan
        int n1 = m - l + 1;
        int n2 = r - m;
        //Buat array temp
        int L[] = new int [n1];
        int R[] = new int [n2];
        //Salin data ke temp array
        for(int i=0; i<n1; ++i)
            L[i] = data[l + i];
        for(int j=0; j<n2; ++j)
            R[j] = data[m+1+j];
        //Gabungkan array temp
        //Indeks awal subarray pertama dan kedua
        int i = 0, j = 0;
        
        int k = l;
        while(i < n1 && j < n2){
            if(L[i] <= R[j]){
                data[k] = L[i];
                i++;
            }
            else{
                data[k] = R[j];
                j++;
            }
            k++;
        }
        
        while(i < n1){
            data[k] = L[i];
            i++;
            k++;
        }
        
        while(j < n2){
            data[k] = R[j];
            j++;
            k++;
        }
    }
    
    void sort(int data[], int l, int r){
        if(l < r){
            int m = (l+r)/2;
            sort(data, l, m);
            sort(data, m+1, r);
            merge(data, l, m, r);
        }
    }
}

