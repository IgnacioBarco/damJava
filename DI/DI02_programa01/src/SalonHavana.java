/********************************************************************************
 ** Form generated from reading ui file 'SalonHavana.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.7
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class SalonHavana implements com.trolltech.qt.QUiForm<QMainWindow>
{
    public QWidget centralwidget;
    public QGroupBox groupBox_Cocina;
    public QWidget horizontalLayoutWidget_2;
    public QHBoxLayout horizontalLayout_Cocina;
    public QRadioButton radioButton_Bufet;
    public QRadioButton radioButton_Carta;
    public QRadioButton radioButton_SolicitarCita;
    public QRadioButton radioButton_NoPrecisa;
    public QGroupBox groupBox_Habitaciones;
    public QWidget horizontalLayoutWidget;
    public QHBoxLayout horizontalLayout_Habitaciones;
    public QRadioButton radioButton_Si;
    public QRadioButton radioButton_No;
    public QGroupBox groupBox_DatosCliente;
    public QWidget gridLayoutWidget;
    public QGridLayout gridLayout_DatosCliente;
    public QLineEdit lineEdit_Localidad;
    public QLabel label_Nombre;
    public QLineEdit lineEdit_Dni;
    public QLabel label_Localidad;
    public QLabel label_Dni;
    public QLineEdit lineEdit_Nombre;
    public QLabel label_Telefono;
    public QLineEdit lineEdit_Telefono;
    public QGroupBox groupBox_FechaEvento;
    public QCalendarWidget calendarWidget_FechaEvento;
    public QGroupBox groupBox_Evento;
    public QWidget verticalLayoutWidget;
    public QVBoxLayout verticalLayout_Evento;
    public QRadioButton radioButton_Banquete;
    public QRadioButton radioButton_Jornada;
    public QRadioButton radioButton_Congreso;
    public QRadioButton radioButton_Boda;
    public QGroupBox groupBox_Congreso;
    public QWidget formLayoutWidget_2;
    public QFormLayout formLayout_Congreso;
    public QLabel label_NumJornadas;
    public QSpinBox spinBox_NumJornadas;
    public QSpacerItem horizontalSpacer;
    public QLabel label_NumTarjeta;
    public QLineEdit lineEdit_NumTarjeta;
    public QPushButton pushButtonDarAlta;
    public QGroupBox groupBox_NumAsistentes;
    public QSpinBox spinBox_NumAsistentes;
    public QMenuBar menubar;
    public QMenu menuSalon_havana;
    public QStatusBar statusbar;

    public SalonHavana() { super(); }

    public void setupUi(QMainWindow MainWindow)
    {
        MainWindow.setObjectName("MainWindow");
        MainWindow.resize(new QSize(825, 532).expandedTo(MainWindow.minimumSizeHint()));
        centralwidget = new QWidget(MainWindow);
        centralwidget.setObjectName("centralwidget");
        groupBox_Cocina = new QGroupBox(centralwidget);
        groupBox_Cocina.setObjectName("groupBox_Cocina");
        groupBox_Cocina.setEnabled(true);
        groupBox_Cocina.setGeometry(new QRect(40, 190, 401, 71));
        groupBox_Cocina.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter).value());
        horizontalLayoutWidget_2 = new QWidget(groupBox_Cocina);
        horizontalLayoutWidget_2.setObjectName("horizontalLayoutWidget_2");
        horizontalLayoutWidget_2.setGeometry(new QRect(0, 20, 381, 31));
        horizontalLayout_Cocina = new QHBoxLayout(horizontalLayoutWidget_2);
        horizontalLayout_Cocina.setSpacing(20);
        horizontalLayout_Cocina.setObjectName("horizontalLayout_Cocina");
        horizontalLayout_Cocina.setContentsMargins(5, -1, -1, -1);
        radioButton_Bufet = new QRadioButton(horizontalLayoutWidget_2);
        radioButton_Bufet.setObjectName("radioButton_Bufet");

        horizontalLayout_Cocina.addWidget(radioButton_Bufet);

        radioButton_Carta = new QRadioButton(horizontalLayoutWidget_2);
        radioButton_Carta.setObjectName("radioButton_Carta");

        horizontalLayout_Cocina.addWidget(radioButton_Carta);

        radioButton_SolicitarCita = new QRadioButton(horizontalLayoutWidget_2);
        radioButton_SolicitarCita.setObjectName("radioButton_SolicitarCita");

        horizontalLayout_Cocina.addWidget(radioButton_SolicitarCita);

        radioButton_NoPrecisa = new QRadioButton(horizontalLayoutWidget_2);
        radioButton_NoPrecisa.setObjectName("radioButton_NoPrecisa");

        horizontalLayout_Cocina.addWidget(radioButton_NoPrecisa);

        groupBox_Habitaciones = new QGroupBox(centralwidget);
        groupBox_Habitaciones.setObjectName("groupBox_Habitaciones");
        groupBox_Habitaciones.setGeometry(new QRect(40, 270, 241, 61));
        groupBox_Habitaciones.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter).value());
        horizontalLayoutWidget = new QWidget(groupBox_Habitaciones);
        horizontalLayoutWidget.setObjectName("horizontalLayoutWidget");
        horizontalLayoutWidget.setGeometry(new QRect(10, 20, 211, 31));
        horizontalLayout_Habitaciones = new QHBoxLayout(horizontalLayoutWidget);
        horizontalLayout_Habitaciones.setSpacing(0);
        horizontalLayout_Habitaciones.setObjectName("horizontalLayout_Habitaciones");
        horizontalLayout_Habitaciones.setContentsMargins(5, -1, -1, -1);
        radioButton_Si = new QRadioButton(horizontalLayoutWidget);
        radioButton_Si.setObjectName("radioButton_Si");

        horizontalLayout_Habitaciones.addWidget(radioButton_Si);

        radioButton_No = new QRadioButton(horizontalLayoutWidget);
        radioButton_No.setObjectName("radioButton_No");

        horizontalLayout_Habitaciones.addWidget(radioButton_No);

        groupBox_DatosCliente = new QGroupBox(centralwidget);
        groupBox_DatosCliente.setObjectName("groupBox_DatosCliente");
        groupBox_DatosCliente.setGeometry(new QRect(40, 0, 401, 181));
        groupBox_DatosCliente.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter).value());
        gridLayoutWidget = new QWidget(groupBox_DatosCliente);
        gridLayoutWidget.setObjectName("gridLayoutWidget");
        gridLayoutWidget.setGeometry(new QRect(9, 9, 381, 161));
        gridLayout_DatosCliente = new QGridLayout(gridLayoutWidget);
        gridLayout_DatosCliente.setObjectName("gridLayout_DatosCliente");
        lineEdit_Localidad = new QLineEdit(gridLayoutWidget);
        lineEdit_Localidad.setObjectName("lineEdit_Localidad");

        gridLayout_DatosCliente.addWidget(lineEdit_Localidad, 4, 1, 1, 1);

        label_Nombre = new QLabel(gridLayoutWidget);
        label_Nombre.setObjectName("label_Nombre");

        gridLayout_DatosCliente.addWidget(label_Nombre, 2, 0, 1, 1);

        lineEdit_Dni = new QLineEdit(gridLayoutWidget);
        lineEdit_Dni.setObjectName("lineEdit_Dni");

        gridLayout_DatosCliente.addWidget(lineEdit_Dni, 3, 1, 1, 1);

        label_Localidad = new QLabel(gridLayoutWidget);
        label_Localidad.setObjectName("label_Localidad");

        gridLayout_DatosCliente.addWidget(label_Localidad, 4, 0, 1, 1);

        label_Dni = new QLabel(gridLayoutWidget);
        label_Dni.setObjectName("label_Dni");

        gridLayout_DatosCliente.addWidget(label_Dni, 3, 0, 1, 1);

        lineEdit_Nombre = new QLineEdit(gridLayoutWidget);
        lineEdit_Nombre.setObjectName("lineEdit_Nombre");
        QSizePolicy sizePolicy = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy.setHorizontalStretch((byte)0);
        sizePolicy.setVerticalStretch((byte)0);
        sizePolicy.setHeightForWidth(lineEdit_Nombre.sizePolicy().hasHeightForWidth());
        lineEdit_Nombre.setSizePolicy(sizePolicy);
        lineEdit_Nombre.setInputMethodHints(com.trolltech.qt.core.Qt.InputMethodHint.createQFlags(com.trolltech.qt.core.Qt.InputMethodHint.ImhNone));

        gridLayout_DatosCliente.addWidget(lineEdit_Nombre, 2, 1, 1, 1);

        label_Telefono = new QLabel(gridLayoutWidget);
        label_Telefono.setObjectName("label_Telefono");

        gridLayout_DatosCliente.addWidget(label_Telefono, 5, 0, 1, 1);

        lineEdit_Telefono = new QLineEdit(gridLayoutWidget);
        lineEdit_Telefono.setObjectName("lineEdit_Telefono");

        gridLayout_DatosCliente.addWidget(lineEdit_Telefono, 5, 1, 1, 1);

        groupBox_FechaEvento = new QGroupBox(centralwidget);
        groupBox_FechaEvento.setObjectName("groupBox_FechaEvento");
        groupBox_FechaEvento.setGeometry(new QRect(460, 30, 331, 201));
        groupBox_FechaEvento.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter).value());
        calendarWidget_FechaEvento = new QCalendarWidget(groupBox_FechaEvento);
        calendarWidget_FechaEvento.setObjectName("calendarWidget_FechaEvento");
        calendarWidget_FechaEvento.setGeometry(new QRect(10, 20, 301, 161));
        calendarWidget_FechaEvento.setSelectedDate(new QDate(2017, 5, 24));
        calendarWidget_FechaEvento.setMinimumDate(new QDate(2017, 5, 24));
        calendarWidget_FechaEvento.setMaximumDate(new QDate(2999, 12, 31));
        calendarWidget_FechaEvento.setFirstDayOfWeek(com.trolltech.qt.core.Qt.DayOfWeek.Monday);
        calendarWidget_FechaEvento.setGridVisible(true);
        groupBox_Evento = new QGroupBox(centralwidget);
        groupBox_Evento.setObjectName("groupBox_Evento");
        groupBox_Evento.setGeometry(new QRect(310, 270, 141, 141));
        groupBox_Evento.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter).value());
        verticalLayoutWidget = new QWidget(groupBox_Evento);
        verticalLayoutWidget.setObjectName("verticalLayoutWidget");
        verticalLayoutWidget.setGeometry(new QRect(0, 10, 101, 141));
        verticalLayout_Evento = new QVBoxLayout(verticalLayoutWidget);
        verticalLayout_Evento.setObjectName("verticalLayout_Evento");
        verticalLayout_Evento.setContentsMargins(5, -1, -1, -1);
        radioButton_Banquete = new QRadioButton(verticalLayoutWidget);
        radioButton_Banquete.setObjectName("radioButton_Banquete");

        verticalLayout_Evento.addWidget(radioButton_Banquete);

        radioButton_Jornada = new QRadioButton(verticalLayoutWidget);
        radioButton_Jornada.setObjectName("radioButton_Jornada");

        verticalLayout_Evento.addWidget(radioButton_Jornada);

        radioButton_Congreso = new QRadioButton(verticalLayoutWidget);
        radioButton_Congreso.setObjectName("radioButton_Congreso");

        verticalLayout_Evento.addWidget(radioButton_Congreso);

        radioButton_Boda = new QRadioButton(verticalLayoutWidget);
        radioButton_Boda.setObjectName("radioButton_Boda");

        verticalLayout_Evento.addWidget(radioButton_Boda);

        groupBox_Congreso = new QGroupBox(centralwidget);
        groupBox_Congreso.setObjectName("groupBox_Congreso");
        groupBox_Congreso.setEnabled(false);
        groupBox_Congreso.setGeometry(new QRect(480, 280, 311, 131));
        groupBox_Congreso.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter).value());
        formLayoutWidget_2 = new QWidget(groupBox_Congreso);
        formLayoutWidget_2.setObjectName("formLayoutWidget_2");
        formLayoutWidget_2.setGeometry(new QRect(10, 10, 291, 121));
        formLayout_Congreso = new QFormLayout(formLayoutWidget_2);
        formLayout_Congreso.setObjectName("formLayout_Congreso");
        formLayout_Congreso.setFieldGrowthPolicy(com.trolltech.qt.gui.QFormLayout.FieldGrowthPolicy.ExpandingFieldsGrow);
        formLayout_Congreso.setFormAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));
        label_NumJornadas = new QLabel(formLayoutWidget_2);
        label_NumJornadas.setObjectName("label_NumJornadas");

        formLayout_Congreso.addWidget(label_NumJornadas);

        spinBox_NumJornadas = new QSpinBox(formLayoutWidget_2);
        spinBox_NumJornadas.setObjectName("spinBox_NumJornadas");
        spinBox_NumJornadas.setMinimum(1);
        spinBox_NumJornadas.setMaximum(50);

        formLayout_Congreso.addWidget(spinBox_NumJornadas);

        horizontalSpacer = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        formLayout_Congreso.addItem(horizontalSpacer);

        label_NumTarjeta = new QLabel(formLayoutWidget_2);
        label_NumTarjeta.setObjectName("label_NumTarjeta");

        formLayout_Congreso.addWidget(label_NumTarjeta);

        lineEdit_NumTarjeta = new QLineEdit(formLayoutWidget_2);
        lineEdit_NumTarjeta.setObjectName("lineEdit_NumTarjeta");

        formLayout_Congreso.addWidget(lineEdit_NumTarjeta);

        pushButtonDarAlta = new QPushButton(centralwidget);
        pushButtonDarAlta.setObjectName("pushButtonDarAlta");
        pushButtonDarAlta.setGeometry(new QRect(40, 440, 751, 23));
        groupBox_NumAsistentes = new QGroupBox(centralwidget);
        groupBox_NumAsistentes.setObjectName("groupBox_NumAsistentes");
        groupBox_NumAsistentes.setGeometry(new QRect(40, 350, 241, 61));
        groupBox_NumAsistentes.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter).value());
        spinBox_NumAsistentes = new QSpinBox(groupBox_NumAsistentes);
        spinBox_NumAsistentes.setObjectName("spinBox_NumAsistentes");
        spinBox_NumAsistentes.setGeometry(new QRect(20, 20, 61, 22));
        spinBox_NumAsistentes.setMinimum(1);
        spinBox_NumAsistentes.setMaximum(500);
        MainWindow.setCentralWidget(centralwidget);
        menubar = new QMenuBar(MainWindow);
        menubar.setObjectName("menubar");
        menubar.setGeometry(new QRect(0, 0, 825, 21));
        menuSalon_havana = new QMenu(menubar);
        menuSalon_havana.setObjectName("menuSalon_havana");
        MainWindow.setMenuBar(menubar);
        statusbar = new QStatusBar(MainWindow);
        statusbar.setObjectName("statusbar");
        MainWindow.setStatusBar(statusbar);
        label_Nombre.setBuddy(lineEdit_Nombre);
        label_Localidad.setBuddy(lineEdit_Localidad);
        label_Dni.setBuddy(lineEdit_Dni);
        label_Telefono.setBuddy(lineEdit_Telefono);
        QWidget.setTabOrder(lineEdit_Nombre, lineEdit_Dni);
        QWidget.setTabOrder(lineEdit_Dni, lineEdit_Localidad);
        QWidget.setTabOrder(lineEdit_Localidad, lineEdit_Telefono);
        QWidget.setTabOrder(lineEdit_Telefono, calendarWidget_FechaEvento);
        QWidget.setTabOrder(calendarWidget_FechaEvento, radioButton_Bufet);
        QWidget.setTabOrder(radioButton_Bufet, radioButton_Carta);
        QWidget.setTabOrder(radioButton_Carta, radioButton_SolicitarCita);
        QWidget.setTabOrder(radioButton_SolicitarCita, radioButton_NoPrecisa);
        QWidget.setTabOrder(radioButton_NoPrecisa, radioButton_Si);
        QWidget.setTabOrder(radioButton_Si, radioButton_No);
        QWidget.setTabOrder(radioButton_No, spinBox_NumAsistentes);
        QWidget.setTabOrder(spinBox_NumAsistentes, radioButton_Banquete);
        QWidget.setTabOrder(radioButton_Banquete, radioButton_Jornada);
        QWidget.setTabOrder(radioButton_Jornada, radioButton_Congreso);
        QWidget.setTabOrder(radioButton_Congreso, radioButton_Boda);
        QWidget.setTabOrder(radioButton_Boda, spinBox_NumJornadas);
        QWidget.setTabOrder(spinBox_NumJornadas, lineEdit_NumTarjeta);
        QWidget.setTabOrder(lineEdit_NumTarjeta, pushButtonDarAlta);

        menubar.addAction(menuSalon_havana.menuAction());
        retranslateUi(MainWindow);
        radioButton_Boda.clicked.connect(groupBox_Congreso, "setDisabled(boolean)");
        radioButton_Congreso.clicked.connect(groupBox_Congreso, "setEnabled(boolean)");
        radioButton_Jornada.clicked.connect(groupBox_Congreso, "setDisabled(boolean)");
        radioButton_Banquete.clicked.connect(groupBox_Congreso, "setDisabled(boolean)");
        pushButtonDarAlta.clicked.connect(pushButtonDarAlta, "click()");

        MainWindow.connectSlotsByName();
    } // setupUi

    void retranslateUi(QMainWindow MainWindow)
    {
        MainWindow.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "MainWindow", null));
        groupBox_Cocina.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Indica el tipo de cocina que quiere el cliente para el evento", null));
        groupBox_Cocina.setTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Tipo de cocina", null));
        radioButton_Bufet.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Bufet", null));
        radioButton_Carta.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Carta", null));
        radioButton_SolicitarCita.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Solicitar cita", null));
        radioButton_NoPrecisa.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "No precisa", null));
        groupBox_Habitaciones.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Indica si se necesita habitaciones parta alojar a los invitados al evento", null));
        groupBox_Habitaciones.setTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "\u00bfNecesita habitaciones?", null));
        radioButton_Si.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Si", null));
        radioButton_No.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "No", null));
        groupBox_DatosCliente.setTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Datos del cliente", null));
        lineEdit_Localidad.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Indica la localidad del cliente", null));
        label_Nombre.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "&Nombre", null));
        lineEdit_Dni.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Indica el dni del cliente", null));
        label_Localidad.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "&Localidad", null));
        label_Dni.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "&DNI", null));
        lineEdit_Nombre.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Indica el nombre del cliente", null));
        label_Telefono.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "&Telefono", null));
        lineEdit_Telefono.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Indica el telefono del cliente", null));
        groupBox_FechaEvento.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Fecha en la que se celebrar el evento", null));
        groupBox_FechaEvento.setTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Fecha del evento", null));
        groupBox_Evento.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Indica el tipo de evento que se desea", null));
        groupBox_Evento.setTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Tipo de evento", null));
        radioButton_Banquete.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Banquete", null));
        radioButton_Jornada.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Jornada", null));
        radioButton_Congreso.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Congreso", null));
        radioButton_Boda.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Boda", null));
        groupBox_Congreso.setToolTip("");
        groupBox_Congreso.setTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Congreso", null));
        label_NumJornadas.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Numero de jornadas:", null));
        spinBox_NumJornadas.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Numero de jornadas que durara el evento", null));
        label_NumTarjeta.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Numero de tarjeta", null));
        lineEdit_NumTarjeta.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Indica el numero de tarjeta para dejar como fianza", null));
        pushButtonDarAlta.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Dar de alta", null));
        groupBox_NumAsistentes.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Indica el numero de asistentes al evento", null));
        groupBox_NumAsistentes.setTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Numero de asistentes", null));
        menuSalon_havana.setTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Salon havana", null));
    } // retranslateUi

}

