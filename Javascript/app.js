(function(input, submit, select, output) {
  submit.addEventListener('click', function() {
    if (input.value == "") output.innerHTML = "Invalid input";
    else {
      let arrToSort = input.value.split(',').map(Number);
      switch (select.value) {
        case 'Bubblesort':
          bubblesort(arrToSort);
          break;

        case 'Insertionsort':
          insertionsort(arrToSort);
          break;

        case 'Selectionsort':
          selectionsort(arrToSort);
          break;

        default:
          quicksort(arrToSort, 0, arrToSort.length - 1);
      }
      output.innerHTML = arrToSort.toString();
    }

    function bubblesort(arr) {
      let sorted = false;
      while (!sorted) {
        sorted = true;
        for (let i = 0; i < arr.length - 1; i++) {
          if (arr[i] > arr[i + 1]) {
            swap(arr, i, i + 1);
            sorted = false;
          }
        }
      }
    }

    function insertionsort(arr) {
      let numToInsert;
      for (let i = 1; i < arr.length; i++) {
        numToInsert = arr[i];
        backwardsCounter = i - 1;

        while (backwardsCounter >= 0 && arr[backwardsCounter] > numToInsert) {
          arr[backwardsCounter + 1] = arr[backwardsCounter];
          backwardsCounter--;
        }
        arr[backwardsCounter + 1] = numToInsert;
      }
    }

    function selectionsort(arr) {
      let smallestIndex = 0;
      for (let i = 0; i < arr.length; i++) {
        for (let smallestCounter = i; smallestCounter < arr.length; smallestCounter++) {
          if (arr[smallestIndex] > arr[smallestCounter]) smallestIndex = smallestCounter;
        }
        if (smallestIndex != i) swap(arr, smallestIndex, i);
      }
    }

    function quicksort(arr, start, end) {
      if (start < end) {
        let pivotIndex = getPivotIndex(arr, start, end);
        quicksort(arr, start, pivotIndex - 1);
        quicksort(arr, pivotIndex + 1, end);
      }
    }

    function getPivotIndex(arr, left, end) {
      let right = end;
      let pivotElement = arr[end];
      while (left < right) {
        while (left < right && arr[left] < pivotElement) left++;
        while (left < right && arr[right] >= pivotElement) right--;
        swap(arr, left, right);
      }
      swap(arr, left, end);
      return left;
    }

    function swap(arr, i1, i2) {
      tmp = arr[i1];
      arr[i1] = arr[i2];
      arr[i2] = tmp;
    }
  });
})(document.querySelector("#input"), document.querySelector("#submit"), document.querySelector(".algo-select"), document.querySelector("#output"));
