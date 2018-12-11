package com.analise;

import com.analise.Algoritms.InsertionSort;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AlgorithmsResult extends JDialog {
	private static final long serialVersionUID = 2690173371281611492L;

	private Integer comparisonQuantity;
	private String complexity;
	
	private boolean showTime;
	private boolean showComparison;
	private boolean showChanges;

	TreeMap<Integer, ResultWrapper> results = new TreeMap<>();

	private boolean processInsertionSort;
	private boolean processSelectionSort;
	private boolean processBubbleSort;
	private boolean processCombSort;
	private boolean processMergeSort;
	private boolean processQuickSort;
	private boolean processRadixSort;
	private boolean processHeapSort;
	private boolean processTimSort;
	private boolean processCountingSort;

	public AlgorithmsResult(
		Integer comparisonQuantity,
		String complexity,

		boolean showTime,
		boolean showComparison,
		boolean showChanges,

		boolean processInsertionSort,
		boolean processSelectionSort,
		boolean processBubbleSort,
		boolean processCombSort,
		boolean processMergeSort,
		boolean processQuickSort,
		boolean processRadixSort,
		boolean processHeapSort,
		boolean processTimSort,
		boolean processCountingSort
	) {
		this.comparisonQuantity = comparisonQuantity;
		this.complexity = complexity;
		this.showTime = showTime;
		this.showComparison = showComparison;
		this.showChanges = showChanges;

		this.processInsertionSort = processInsertionSort;
		this.processSelectionSort = processSelectionSort;
		this.processBubbleSort = processBubbleSort;
		this.processCombSort = processCombSort;
		this.processMergeSort = processMergeSort;
		this.processQuickSort = processQuickSort;
		this.processRadixSort = processRadixSort;
		this.processHeapSort = processHeapSort;
		this.processTimSort = processTimSort;
		this.processCountingSort = processCountingSort;

		doTest();
		createComponents();
	}
	
	private void createComponents() {
		getContentPane().setLayout(null);

		int panelHeight = ((results.size() / 2 + results.size() % 2) * 35) + 40;
		int panelVerticalPos = 7;

		//Tempo
		if (showTime) {
			JPanel pnlTempo = new JPanel();
			pnlTempo.setBounds(31, panelVerticalPos, 592, panelHeight);
			pnlTempo.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)), "Tempo (ms)", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			getContentPane().add(pnlTempo);
			pnlTempo.setLayout(null);

			int fieldsVerticalPos = -5;
			int fieldsHorizontalPos;
			for (Map.Entry<Integer, ResultWrapper> entry : results.entrySet()) {
				Integer k = entry.getKey();
				ResultWrapper result = entry.getValue();
				fieldsVerticalPos += (k % 2 != 0) ? 35 : 0;
				fieldsHorizontalPos = (k % 2 != 0) ? 29 : 294;

				JLabel label = new JLabel(result.getLabel());
				label.setBounds(fieldsHorizontalPos, fieldsVerticalPos, 93, 20);
				pnlTempo.add(label);

				JTextField textField = new JTextField();
				textField.setBounds(fieldsHorizontalPos + 103, fieldsVerticalPos, 116, 20);
				textField.setColumns(10);
				textField.setText(result.getTime());
				pnlTempo.add(textField);
			}

			panelVerticalPos += panelHeight + 20;
		}

		//Trocas
		if (showChanges) {
			JPanel pnlTroca = new JPanel();
			pnlTroca.setBounds(31, panelVerticalPos, 592, panelHeight);
			pnlTroca.setLayout(null);
			pnlTroca.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)), "Trocas (ms)", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			getContentPane().add(pnlTroca);

			int fieldsVerticalPos = -5;
			int fieldsHorizontalPos;
			for (Map.Entry<Integer, ResultWrapper> entry : results.entrySet()) {
				Integer k = entry.getKey();
				ResultWrapper result = entry.getValue();
				fieldsVerticalPos += (k % 2 != 0) ? 35 : 0;
				fieldsHorizontalPos = (k % 2 != 0) ? 29 : 294;

				JLabel label = new JLabel(result.getLabel());
				label.setBounds(fieldsHorizontalPos, fieldsVerticalPos, 93, 20);
				pnlTroca.add(label);

				JTextField textField = new JTextField();
				textField.setBounds(fieldsHorizontalPos + 103, fieldsVerticalPos, 116, 20);
				textField.setColumns(10);
				textField.setText(result.getChanges());
				pnlTroca.add(textField);
			}

			panelVerticalPos += panelHeight + 20;
		}

		//Comparações
		if (showComparison) {
			JPanel pnlComp = new JPanel();
			pnlComp.setLayout(null);
			pnlComp.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)), "Compara\u00E7\u00F5es (ms)", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pnlComp.setBounds(31, panelVerticalPos, 592, panelHeight);
			getContentPane().add(pnlComp);

			int fieldsVerticalPos = -5;
			int fieldsHorizontalPos;
			for (Map.Entry<Integer, ResultWrapper> entry : results.entrySet()) {
				Integer k = entry.getKey();
				ResultWrapper result = entry.getValue();
				fieldsVerticalPos += (k % 2 != 0) ? 35 : 0;
				fieldsHorizontalPos = (k % 2 != 0) ? 29 : 294;

				JLabel label = new JLabel(result.getLabel());
				label.setBounds(fieldsHorizontalPos, fieldsVerticalPos, 93, 20);
				pnlComp.add(label);

				JTextField textField = new JTextField();
				textField.setBounds(fieldsHorizontalPos + 103, fieldsVerticalPos, 116, 20);
				textField.setColumns(10);
				textField.setText(result.getComparison());
				pnlComp.add(textField);
			}

			panelVerticalPos += panelHeight + 20;
		}

		int dialogHeight = (panelVerticalPos + 40) < 400 ? 400 : (panelVerticalPos + 40);

		setBounds(30, 30, 669, dialogHeight);
	}

	private void doTest() {
		//Create Array
		ArrayHelper arrayHelper = new ArrayHelper(comparisonQuantity, complexity);
		int[] array = arrayHelper.generateArray();

		//Reset Results
		results.clear();

		//INSERTION SORT
		if (processInsertionSort) {
			InsertionSort insertionSort = new InsertionSort();

			//Aciona a função de ordenação
			insertionSort.sort(array);

			//Resultado
			results.put(results.size() + 1, new ResultWrapper( "Insertion Sort", insertionSort.getTime(), insertionSort.getComparison(), insertionSort.getChanges()));
		}

		//SELECTION SORT
		if (processSelectionSort) {


			//Aciona a função de ordenação


			//Resultado
			results.put(results.size() + 1, new ResultWrapper("Selection Sort", 0, 0, 0));
		}

		//BUBBLE SORT
		if (processBubbleSort) {


			//Aciona a função de ordenação


			//Resultado
			results.put(results.size() + 1, new ResultWrapper("Bubble Sort", 0, 0, 0));
		}

		//COMB SORT
		if (processCombSort) {


			//Aciona a função de ordenação


			//Resultado
			results.put(results.size() + 1, new ResultWrapper("Comb Sort", 0, 0, 0));
		}

		//MERGE SORT
		if (processMergeSort) {


			//Aciona a função de ordenação


			//Resultado
			results.put(results.size() + 1, new ResultWrapper("Merge Sort", 0, 0, 0));
		}

		//HEAP SORT
		if (processHeapSort) {


			//Aciona a função de ordenação


			//Resultado
			results.put(results.size() + 1, new ResultWrapper("Heap Sort", 0, 0, 0));
		}
		//QUICK SORT
		if (processQuickSort) {


			//Aciona a função de ordenação


			//Resultado
			results.put(results.size() + 1, new ResultWrapper("Quick Sort", 0, 0, 0));
		}

		//RADIX SORT
		if (processRadixSort) {


			//Aciona a função de ordenação


			//Resultado
			results.put(results.size() + 1, new ResultWrapper("Radix Sort", 0, 0, 0));
		}

		//TIM SORT
		if (processTimSort) {


			//Aciona a função de ordenação


			//Resultado
			results.put(results.size() + 1, new ResultWrapper("Tim Sort", 0, 0, 0));
		}

		//COUNTING SORT
		if (processCountingSort) {


			//Aciona a função de ordenação


			//Resultado
			results.put(results.size() + 1, new ResultWrapper("Counting Sort", 0, 0, 0));
		}
	}

	private class ResultWrapper {
		private String label;
		private long time;
		private int comparison;
		private int changes;

		public ResultWrapper(String label, long time, int comparison, int changes) {
			this.label = label;
			this.time = time;
			this.comparison = comparison;
			this.changes = changes;
		}

		public String getLabel() {
			return label;
		}

		public String getTime() {
			return String.valueOf(time);
		}

		public String getComparison() {
			return String.valueOf(comparison);
		}

		public String getChanges() {
			return String.valueOf(changes);
		}
	}
}
