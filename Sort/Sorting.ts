class Sort {
    
    //交换变量
    public swap(x:number,y:number) {
        //es6 变量结构赋值
        [x, y] = [y, x];
    }

    
    /**
     * 冒泡算法 
     * 外循环为遍历元素次数，长度为数组长度 - 1
     * 内循环为让前者往上冒泡，每冒泡一个上去，对应循环次数 - 已遍历元素数目
     * @param array 
     */
    public bubble(array:Array<number>) {
        for(let i = 0 ; i < array.length - 1; i++) {
            for(let j = 0; j < array.length - 1 - i; j++) {
                if(array[j] > array[j+1]) {
                    this.swap(array[j],array[j+1]);
                }
            }
        }
    }

    /**
     * 插入排序（与冒泡相似）
     * 外循环为遍历元素次数
     * 设置第一个遍历元素为已排序元素，即为最小元素
     * 经过内循环，遍历当前除未排序的元素，如比最小元素还小，则进行置换
     * 
     * @param array 
     */
    public selection(array:Array<number>) {
        for(let i = 0; i < array.length - 1; i++) {
            let min = i;
            for(let j = i + 1; j < array.length; j++) {
                if(array[j] < array[min]) {
                    min = j;
                }
            }
            this.swap(array[i],array[min]);
        }
    }

    /**
     * 插入排序
     * 外循环为遍历元素次数，默认第一个元素为已排序元素，所以数组从1开始，取出该元素a[x]进行比较
     * 内循环为遍历已排序的序列，与该序列的每个元素比较，大则置换，小则插入
     * @param array 
     */
    public insertion(array:Array<number>) {
        for(let i = 1; i < array.length; i++) {
            let x = i;
            let j = i - 1;
            for(j; j >= 0; j--) {
                if(array[j] > array[x]) {
                    this.swap(array[j],array[x]);
                }
            }
        }
    }
}