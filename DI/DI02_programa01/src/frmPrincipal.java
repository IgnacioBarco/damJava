/********************************************************************************
 ** Form generated from reading ui file 'frmPrincipal.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.7
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class frmPrincipal implements com.trolltech.qt.QUiForm<QMainWindow>
{
    public QAction actionReservas;
    public QAction actionSalir;
    public QAction actionReservas2;
    public QAction actionReservas_Salon_Havana;
    public QWidget centralwidget;
    public QPushButton pushButton_Reservas;
    public QPushButton pushButton_Salir;
    public QLabel label;
    public QPushButton pushButton_ReservaHavan;
    public QMenuBar menubar;
    public QMenu menuAplicaci_n;
    public QMenu menuGesti_n;
    public QStatusBar statusbar;

    public frmPrincipal() { super(); }
    
    void abrir(){

        frmAlta Alta = new frmAlta();
        QDialog dialog = new QDialog();
        Alta.setupUi(dialog);
        dialog.show();

    }
    
    void abrir2(){

        SalonHavana sH = new SalonHavana();
        QMainWindow dialog2 = new QMainWindow();
        sH.setupUi(dialog2);
        dialog2.show();

    }

    public void setupUi(QMainWindow MainWindow)
    {
        MainWindow.setObjectName("MainWindow");
        MainWindow.resize(new QSize(500, 300).expandedTo(MainWindow.minimumSizeHint()));
        
        actionSalir = new QAction(MainWindow);
        actionSalir.setObjectName("actionSalir");
        /******************************************************
         * Añadimos funcionalidad al menú
         */
        actionSalir.triggered.connect(MainWindow, "close()");
        /*********************************************************/

        actionReservas = new QAction(MainWindow);
        actionReservas.setObjectName("actionReservas");
        /******************************************************
         * Añadimos funcionalidad al menú
         */
        actionReservas.triggered.connect(this, "abrir()");
        /*********************************************************/
        
        actionReservas2 = new QAction(MainWindow);
        actionReservas2.setObjectName("actionReservas2");
        /******************************************************
         * Añadimos funcionalidad al menú
         */
        actionReservas2.triggered.connect(this, "abrir2()");
        /*********************************************************/
        
        actionReservas_Salon_Havana = new QAction(MainWindow);
        actionReservas_Salon_Havana.setObjectName("actionReservas_Salon_Havana");
        centralwidget = new QWidget(MainWindow);
        centralwidget.setObjectName("centralwidget");
        pushButton_Reservas = new QPushButton(centralwidget);
        pushButton_Reservas.setObjectName("pushButton_Reservas");
        pushButton_Reservas.setGeometry(new QRect(340, 30, 131, 27));
        pushButton_Salir = new QPushButton(centralwidget);
        pushButton_Salir.setObjectName("pushButton_Salir");
        pushButton_Salir.setGeometry(new QRect(380, 220, 98, 27));
        label = new QLabel(centralwidget);
        label.setObjectName("label");
        label.setGeometry(new QRect(20, 10, 341, 231));
        label.setPixmap(new QPixmap(("recursos/hotel.jpg")));
        label.setScaledContents(true);
        pushButton_ReservaHavan = new QPushButton(centralwidget);
        pushButton_ReservaHavan.setObjectName("pushButton_ReservaHavan");
        pushButton_ReservaHavan.setGeometry(new QRect(340, 70, 131, 31));
        MainWindow.setCentralWidget(centralwidget);
        menubar = new QMenuBar(MainWindow);
        menubar.setObjectName("menubar");
        menubar.setGeometry(new QRect(0, 0, 500, 21));
        menuAplicaci_n = new QMenu(menubar);
        menuAplicaci_n.setObjectName("menuAplicaci_n");
        menuGesti_n = new QMenu(menubar);
        menuGesti_n.setObjectName("menuGesti_n");
        MainWindow.setMenuBar(menubar);
        statusbar = new QStatusBar(MainWindow);
        statusbar.setObjectName("statusbar");
        MainWindow.setStatusBar(statusbar);

        menuAplicaci_n.addAction(actionSalir);
        menuGesti_n.addAction(actionReservas);
        menuGesti_n.addAction(actionReservas2);
         
        menubar.addAction(menuAplicaci_n.menuAction());
        menubar.addAction(menuGesti_n.menuAction());
        
        
        
        retranslateUi(MainWindow);
        /*****************************************************************
         * Aquí pongo la conexión signal/slot de usuario
         * Al hacer clic en el botón Reservas se abre el dialogo de reservas.
         */        
        pushButton_Salir.clicked.connect(MainWindow, "close()");
        pushButton_Reservas.clicked.connect(this, "abrir()");
        pushButton_ReservaHavan.clicked.connect(this, "abrir2()");
       
        MainWindow.connectSlotsByName();
    } // setupUi

    void retranslateUi(QMainWindow MainWindow)
    {
        MainWindow.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "MainWindow", null));
        actionSalir.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Salir", null));
        pushButton_Salir.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "&Salir", null));
        
        
        actionReservas.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Reservas", null));
        actionReservas2.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Reservas Salon Havana", null));
        pushButton_Reservas.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "&Reservas", null));
        pushButton_Salir.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "&Salir", null));
        label.setText("");
        pushButton_ReservaHavan.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Reserva_Salon_Havana", null));
        menuAplicaci_n.setTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Aplicaci\u00f3n", null));
        menuGesti_n.setTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Gesti\u00f3n", null));
    } // retranslateUi

}

