package com.analise;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JSeparator;
import javax.swing.JButton;

public class Algoritmos extends JInternalFrame {
	private static final long serialVersionUID = 649962792853519117L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Algoritmos frame = new Algoritmos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Algoritmos() {
		setBounds(100, 100, 690, 384);
		getContentPane().setLayout(null);
		
		JPanel pnlAlgOrd = new JPanel();
		pnlAlgOrd.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)), "Algoritmos de Ordena\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlAlgOrd.setBounds(36, 74, 276, 212);
		getContentPane().add(pnlAlgOrd);
		pnlAlgOrd.setLayout(null);
		
		JCheckBox chbInsertionSort = new JCheckBox("Insertion Sort");
		chbInsertionSort.setBounds(17, 30, 97, 23);
		pnlAlgOrd.add(chbInsertionSort);
		
		JCheckBox chbSelectionSort = new JCheckBox("Selection Sort");
		chbSelectionSort.setBounds(17, 65, 97, 23);
		pnlAlgOrd.add(chbSelectionSort);
		
		JCheckBox chbBubbleSort = new JCheckBox("Bulbble Sort");
		chbBubbleSort.setBounds(17, 100, 97, 23);
		pnlAlgOrd.add(chbBubbleSort);
		
		JCheckBox chbCombSort = new JCheckBox("Comb Sort");
		chbCombSort.setBounds(17, 135, 97, 23);
		pnlAlgOrd.add(chbCombSort);
		
		JCheckBox chbMergeSort = new JCheckBox("Merge Sort");
		chbMergeSort.setBounds(17, 170, 97, 23);
		pnlAlgOrd.add(chbMergeSort);
		
		JCheckBox chbHeapSort = new JCheckBox("Heap Sort");
		chbHeapSort.setBounds(155, 30, 97, 23);
		pnlAlgOrd.add(chbHeapSort);
		
		JCheckBox chbRadixSort = new JCheckBox("Radix Sort");
		chbRadixSort.setBounds(155, 65, 97, 23);
		pnlAlgOrd.add(chbRadixSort);
		
		JCheckBox chbQuickSort = new JCheckBox("Quick Sort");
		chbQuickSort.setBounds(155, 100, 97, 23);
		pnlAlgOrd.add(chbQuickSort);
		
		JCheckBox chbTimkSort = new JCheckBox("Tim Sort");
		chbTimkSort.setBounds(155, 135, 97, 23);
		pnlAlgOrd.add(chbTimkSort);
		
		JCheckBox chbCountingSort = new JCheckBox("Counting Sort");
		chbCountingSort.setBounds(155, 170, 97, 23);
		pnlAlgOrd.add(chbCountingSort);
		
		JPanel pnlCasosAtrib = new JPanel();
		pnlCasosAtrib.setLayout(null);
		pnlCasosAtrib.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)), "Casos e Atributos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlCasosAtrib.setBounds(357, 74, 276, 212);
		getContentPane().add(pnlCasosAtrib);
		
		JRadioButton rbtMelhorCaso = new JRadioButton("Melhor Caso");
		rbtMelhorCaso.setBounds(22, 30, 109, 23);
		pnlCasosAtrib.add(rbtMelhorCaso);
		
		JRadioButton rbtrPiorCaso = new JRadioButton("Pior Caso");
		rbtrPiorCaso.setBounds(22, 65, 109, 23);
		pnlCasosAtrib.add(rbtrPiorCaso);
		
		JRadioButton rbtCasoMedio = new JRadioButton("Caso Médio");
		rbtCasoMedio.setBounds(22, 100, 109, 23);
		pnlCasosAtrib.add(rbtCasoMedio);
		rbtCasoMedio.setSelected(true);
		
		JCheckBox chbTempo = new JCheckBox("Tempo");
		chbTempo.setBounds(146, 30, 97, 23);
		pnlCasosAtrib.add(chbTempo);
		chbTempo.setSelected(true);
		
		JCheckBox chbComp = new JCheckBox("Comparações");
		chbComp.setBounds(146, 65, 97, 23);
		pnlCasosAtrib.add(chbComp);
		
		JCheckBox chbTrocas = new JCheckBox("Trocas");
		chbTrocas.setBounds(146, 100, 97, 23);
		pnlCasosAtrib.add(chbTrocas);
		
		JLabel lblQuantVal = new JLabel("Quantidade de Valores: ");
		lblQuantVal.setBounds(36, 30, 128, 20);
		getContentPane().add(lblQuantVal);
		
		JSpinner spnQuantVal = new JSpinner();
		spnQuantVal.setBounds(174, 30, 138, 20);
		getContentPane().add(spnQuantVal);
		spnQuantVal.setValue(5000);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(29, 17, 604, 2);
		getContentPane().add(separator_1);
		
		JButton btnProcessar = new JButton("Processar");
		btnProcessar.setBounds(533, 311, 100, 23);
		getContentPane().add(btnProcessar);
		
		btnProcessar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Pega a complexidade dependendo do caso selecionado
				String complexity;
				if (rbtMelhorCaso.isSelected()) {
					complexity = ArrayHelper.COMPLEXITY_BEST;
					;
				} else if (rbtrPiorCaso.isSelected()) {
					complexity = ArrayHelper.COMPLEXITY_WORSE;
				} else {
					complexity = ArrayHelper.COMPLEXITY_MEDIUM;
				}

				new AlgorithmsResult(
						Integer.parseInt(spnQuantVal.getValue().toString()), //Qtde comparações
						complexity, //Complexidade array para ordenação
						
						chbTempo.isSelected(), //Tempo
						chbComp.isSelected(), //Comparações
						chbTrocas.isSelected(), //Trocas

						chbInsertionSort.isSelected(),
						chbSelectionSort.isSelected(),
						chbBubbleSort.isSelected(),
						chbCombSort.isSelected(),
						chbMergeSort.isSelected(),
						chbQuickSort.isSelected(),
						chbRadixSort.isSelected(),
						chbHeapSort.isSelected(),
						chbTimkSort.isSelected(),
						chbCountingSort.isSelected()
				).setVisible(true);
			}
		});

	}
}
