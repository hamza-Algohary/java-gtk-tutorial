package com.mycompany.gtktutorial;
import java.io.File;
import java.nio.file.Path;

import javax.swing.text.StyleConstants;

import ch.bailu.gtk.adw.HeaderBar;
import ch.bailu.gtk.adw.MessageDialog;
import ch.bailu.gtk.gdkpixbuf.Pixbuf;
import ch.bailu.gtk.gio.Action;
import ch.bailu.gtk.gio.ApplicationFlags;
import ch.bailu.gtk.glib.Glib;
import ch.bailu.gtk.glib.GlibConstants;
import ch.bailu.gtk.gtk.AboutDialog;
import ch.bailu.gtk.gtk.Align;
import ch.bailu.gtk.gtk.Application;
import ch.bailu.gtk.gtk.ApplicationWindow;
import ch.bailu.gtk.gtk.Box;
import ch.bailu.gtk.gtk.Button;
import ch.bailu.gtk.gtk.CheckButton;
import ch.bailu.gtk.gtk.CssProvider;
import ch.bailu.gtk.gtk.EditableLabel;
import ch.bailu.gtk.gtk.Entry;
import ch.bailu.gtk.gtk.FileChooserAction;
import ch.bailu.gtk.gtk.FileChooserDialog;
import ch.bailu.gtk.gtk.Image;
import ch.bailu.gtk.gtk.Label;
import ch.bailu.gtk.gtk.LevelBar;
import ch.bailu.gtk.gtk.Orientable;
import ch.bailu.gtk.gtk.Orientation;
import ch.bailu.gtk.gtk.PasswordEntry;
import ch.bailu.gtk.gtk.Picture;
import ch.bailu.gtk.gtk.PolicyType;
import ch.bailu.gtk.gtk.ProgressBar;
import ch.bailu.gtk.gtk.ScrolledWindow;
import ch.bailu.gtk.gtk.Separator;
import ch.bailu.gtk.gtk.Spinner;
import ch.bailu.gtk.gtk.Stack;
import ch.bailu.gtk.gtk.StyleContext;
import ch.bailu.gtk.gtk.Switch;
import ch.bailu.gtk.gtk.Text;
import ch.bailu.gtk.gtk.TextView;
import ch.bailu.gtk.gtk.ToggleButton;
import ch.bailu.gtk.gtk.Window;
import ch.bailu.gtk.pango.Alignment;
import ch.bailu.gtk.type.Str;
import ch.bailu.gtk.type.Strs;

public class Examples {
    public static void window(String args[]){
        var app = new Application("com.example.hello", ApplicationFlags.FLAGS_NONE);

        app.onActivate(() -> {
            Window window = new ApplicationWindow(app);
            window.show();
        });

        app.run(args.length, new Strs(args)); 
    }

    public static void test(String args[]){
        var app = new Application("com.example.hello", ApplicationFlags.FLAGS_NONE);

        app.onActivate(() -> {
            Window window = new ApplicationWindow(app);

            Button button = new Button();
            button.setLabel("Hello, World!");
            button.onClicked(window::close);

            window.setChild(button);
            window.show();
        });

        app.run(args.length, new Strs(args));  
    }

    public static void label(String args[]){
        var app = new Application("com.example.hello", ApplicationFlags.FLAGS_NONE);

        app.onActivate(() -> {
            Window window = new ApplicationWindow(app);

            Label label = new Label("HelloWorld");
            window.setChild(label);

            window.show();
        });

        app.run(args.length, new Strs(args));  
    }

    public static void button(String args[]){
        var app = new Application("com.example.hello", ApplicationFlags.FLAGS_NONE);

        app.onActivate(() -> {
            Window window = new ApplicationWindow(app);

            Button button = new Button();
            button.setLabel("Click Me !");

            window.setChild(button);
            window.show();
        });

        app.run(args.length, new Strs(args));  
    }


    public static void horizontalBox(String args[]){
        var app = new Application("com.example.hello", ApplicationFlags.FLAGS_NONE);

        app.onActivate(() -> {
            Window window = new ApplicationWindow(app);

            Button button1 = new Button();
            button1.setLabel("Click Me !");

            Button button2 = new Button();
            button2.setLabel("Click Me !");

            Button button3 = new Button();
            button3.setLabel("Click Me !");

            Box box = new Box(Orientation.HORIZONTAL, 0);

            box.append(button1);
            box.append(button2);
            box.append(button3);

            window.setChild(box);
            window.show();
        });

        app.run(args.length, new Strs(args));  
    }

    public static void verticalBox(String args[]){
        var app = new Application("com.example.hello", ApplicationFlags.FLAGS_NONE);

        app.onActivate(() -> {
            Window window = new ApplicationWindow(app);

            Button button1 = new Button();
            button1.setLabel("Click Me !");

            Button button2 = new Button();
            button2.setLabel("Click Me !");

            Button button3 = new Button();
            button3.setLabel("Click Me !");

            Box box = new Box(Orientation.VERTICAL, 0);

            box.append(button1);
            box.append(button2);
            box.append(button3);

            window.setChild(box);
            window.show();
        });

        app.run(args.length, new Strs(args));   
    }

    public static void expanding(String args[]){
        var app = new Application("com.example.hello", ApplicationFlags.FLAGS_NONE);

        app.onActivate(() -> {
            Window window = new ApplicationWindow(app);

            Button button1 = new Button();
            button1.setLabel("Click Me !");

            Button button2 = new Button();
            button2.setLabel("Click Me !");

            Button button3 = new Button();
            button3.setLabel("Click Me !");

            button2.setHexpand(true);

            Box box = new Box(Orientation.HORIZONTAL, 0);

            box.append(button1);
            box.append(button2);
            box.append(button3);

            window.setChild(box);
            window.show();
        });

        app.run(args.length, new Strs(args));   
    }


    public static void alignment(String args[]){
        var app = new Application("com.example.hello", ApplicationFlags.FLAGS_NONE);

        app.onActivate(() -> {
            Window window = new ApplicationWindow(app);

            Button button1 = new Button();
            button1.setLabel("Click Me !");

            Button button2 = new Button();
            button2.setLabel("Click Me !");

            Button button3 = new Button();
            button3.setLabel("Click Me !");

            Box box = new Box(Orientation.HORIZONTAL, 0);
            box.setHalign(Align.END); // START, END, CENTER, FILL

            box.append(button1);
            box.append(button2);
            box.append(button3);

            window.setChild(box);
            window.show();
        });

        app.run(args.length, new Strs(args));   
    }

    // For icons.
    public static void image(String args[]){
        var app = new Application("com.example.hello", ApplicationFlags.FLAGS_NONE);

        app.onActivate(() -> {
            Window window = new ApplicationWindow(app);

            Image image = new Image();
            image.setFromFile("src/main/resources/media/circle.svg");

            window.setChild(image);
            window.show();
        });

        app.run(args.length, new Strs(args));   
    }
    
    // For images.
    public static void picture(String args[]){
        var app = new Application("com.example.hello", ApplicationFlags.FLAGS_NONE);

        app.onActivate(() -> {
            Window window = new ApplicationWindow(app);

            Picture pic = new Picture();
            pic.setFilename("src/main/resources/media/numbers_in_quran.jpg");

            window.setChild(pic);
            window.show();
        });

        app.run(args.length, new Strs(args));   
    }

    public static void spinner(String args[]){
        var app = new Application("com.example.hello", ApplicationFlags.FLAGS_NONE);

        app.onActivate(() -> {
            Window window = new ApplicationWindow(app);

            Spinner spinner = new Spinner();
            spinner.start();

            window.setChild(spinner);
            window.show();
        });

        app.run(args.length, new Strs(args));   
    }

    public static void levelBar(String args[]){
        var app = new Application("com.example.hello", ApplicationFlags.FLAGS_NONE);

        app.onActivate(() -> {
            Window window = new ApplicationWindow(app);

            LevelBar bar = new LevelBar();
            bar.setMaxValue(100);
            bar.setMinValue(0);
            bar.setValue(30);

            window.setChild(bar);
            window.show();
        });

        app.run(args.length, new Strs(args));   
    }


    public static void separator(String args[]){
        var app = new Application("com.example.hello", ApplicationFlags.FLAGS_NONE);

        app.onActivate(() -> {
            Window window = new ApplicationWindow(app);

            Label label1 = new Label("label 1");
            Label label2 = new Label("label 2");
            Label label3 = new Label("label 3");

            Separator separator = new Separator(Orientation.VERTICAL);

            Box box = new Box(Orientation.HORIZONTAL, 0);

            box.append(label1);
            box.append(label2);
            box.append(separator);
            box.append(label3);

            window.setChild(box);
            window.show();
        });

        app.run(args.length, new Strs(args));  
    }

    public static void textView(String args[]){
        var app = new Application("com.example.hello", ApplicationFlags.FLAGS_NONE);

        app.onActivate(() -> {
            Window window = new ApplicationWindow(app);

            TextView view = new TextView();

            window.setChild(view);
            window.show();
        });

        app.run(args.length, new Strs(args));  
    }

    public static void toggleButton(String args[]){
        var app = new Application("com.example.hello", ApplicationFlags.FLAGS_NONE);

        app.onActivate(() -> {
            Window window = new ApplicationWindow(app);

            ToggleButton toggleButton = new ToggleButton();
            toggleButton.setLabel("Toggle");

            window.setChild(toggleButton);
            window.show();
        });

        app.run(args.length, new Strs(args));  
    }

    public static void checkButton(String args[]){
        var app = new Application("com.example.hello", ApplicationFlags.FLAGS_NONE);

        app.onActivate(() -> {
            Window window = new ApplicationWindow(app);

            CheckButton checkButton = new CheckButton();
            checkButton.setLabel("Add to desktop.");

            window.setChild(checkButton);
            window.show();
        });

        app.run(args.length, new Strs(args));  
    }
    

    public static void switchButton(String args[]){
        var app = new Application("com.example.hello", ApplicationFlags.FLAGS_NONE);

        app.onActivate(() -> {
            Window window = new ApplicationWindow(app);

            Switch switch1 = new Switch();

            window.setChild(switch1);
            window.show();
        });

        app.run(args.length, new Strs(args));  
    }

    public static void entry(String args[]){
        var app = new Application("com.example.hello", ApplicationFlags.FLAGS_NONE);

        app.onActivate(() -> {
            Window window = new ApplicationWindow(app);

            Entry entry1 = new Entry();
            String text = "Type something";
            entry1.getBuffer().setText(text, text.length());

            window.setChild(entry1);
            window.show();
        });

        app.run(args.length, new Strs(args));  
    }
    
    public static void passwordEntry(String args[]){
        var app = new Application("com.example.hello", ApplicationFlags.FLAGS_NONE);

        app.onActivate(() -> {
            Window window = new ApplicationWindow(app);

            PasswordEntry entry1 = new PasswordEntry();

            window.setChild(entry1);
            window.show();
        });

        app.run(args.length, new Strs(args));  
    }

    public static void editableLabel(String args[]){
        var app = new Application("com.example.hello", ApplicationFlags.FLAGS_NONE);

        app.onActivate(() -> {
            Window window = new ApplicationWindow(app);

            EditableLabel label = new EditableLabel("Edit This.");

            window.setChild(label);
            window.show();
        });

        app.run(args.length, new Strs(args));  
    }

    public static void scrolledWindow(String args[]){
        var app = new Application("com.example.hello", ApplicationFlags.FLAGS_NONE);

        app.onActivate(() -> {
            Window window = new ApplicationWindow(app);

            Button buttons[] = new Button[100];
            for(int i=0 ; i<buttons.length ; i++){
                buttons[i] = new Button();
                buttons[i].setLabel("Button "+i);
            }

            Box box = new Box(Orientation.VERTICAL, 0);

            for(int i=0 ; i<buttons.length ; i++){
                box.append(buttons[i]);
            }

            ScrolledWindow scrolledWindow = new ScrolledWindow();
            scrolledWindow.setChild(box);

            scrolledWindow.setPolicy(PolicyType.NEVER, PolicyType.ALWAYS);

            window.setChild(scrolledWindow);
            window.show();
        });

        app.run(args.length, new Strs(args));  
    }

    public static void headerBar(String args[]){
        var app = new Application("com.example.hello", ApplicationFlags.FLAGS_NONE);

        app.onActivate(() -> {
            Window window = new ApplicationWindow(app);

            Button saveButton = new Button();
            saveButton.setLabel("Save");

            HeaderBar titlebar = new HeaderBar();
            titlebar.packStart(saveButton);

            TextView view = new TextView();

            window.setTitle("Notes");
            window.setTitlebar(titlebar);
            window.setChild(view);
            window.show();
        });

        app.run(args.length, new Strs(args));  
    }

    public static void eventHandling(String args[]){
        var app = new Application("com.example.hello", ApplicationFlags.FLAGS_NONE);

        app.onActivate(() -> {
            Window window = new ApplicationWindow(app);

            Button button = new Button();
            button.setLabel("Click Me !");

            button.onClicked(()->{
                System.out.println("Button Clicked !");
            });

            window.setChild(button);
            window.show();
        });

        app.run(args.length, new Strs(args));  
    }

    public static void eventHandling2(String args[]){
        var app = new Application("com.example.hello", ApplicationFlags.FLAGS_NONE);

        app.onActivate(() -> {
            Window window = new ApplicationWindow(app);

            TextView view = new TextView();
            view.getBuffer().onChanged(()->{
                System.out.println("Text Changed");
            });

            window.setChild(view);
            window.show();
        });

        app.run(args.length, new Strs(args));  
    }

    public static void aboutDialog(String args[]){
        var app = new Application("com.example.hello", ApplicationFlags.FLAGS_NONE);

        app.onActivate(() -> {

            AboutDialog aboutDialog = new AboutDialog();
            aboutDialog.setProgramName("Gtk Tutorial");
            aboutDialog.setAuthors(new Strs(new String[]{"Hamza Algohary"}));
            aboutDialog.setVersion("0.6.0");

            aboutDialog.show();
        });

        app.run(args.length, new Strs(args));  
    }

    
    public static void fileChooserDialog(String args[]){
        var app = new Application("com.example.hello", ApplicationFlags.FLAGS_NONE);

        app.onActivate(() -> {
            Window window = new ApplicationWindow(app);
            FileChooserDialog fileChooserDialog = new FileChooserDialog("Open File", window , FileChooserAction.OPEN , "Open" , 0 , "Cancel" , 1);

            fileChooserDialog.onResponse((int response)->{
                if(response == 0)
                    System.out.println("Opening " + fileChooserDialog.asFileChooser().getFile().getPath().toString());
                else
                    System.out.println("Operation Cancelled");
                
                fileChooserDialog.hide();
            });  

            window.show();
            fileChooserDialog.show();

        });

        app.run(args.length, new Strs(args));  
    }

    public static void stack(String args[]){
        var app = new Application("com.example.hello", ApplicationFlags.FLAGS_NONE);

        app.onActivate(() -> {
            Window window = new ApplicationWindow(app);

            Button button1 = new Button();
            button1.setLabel("Article 1");


            Button button2 = new Button();
            button2.setLabel("Article 2");


            HeaderBar titlebar = new HeaderBar();
            titlebar.packStart(button1);
            titlebar.packStart(button2);

            TextView view = new TextView();
            String str = "Lorem ipsum dolor sit amet,\n consectetur adipiscing elit,\n sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n\n";
            view.getBuffer().setText(str, str.length());

            Image image = Image.newFromFileImage("src/main/resources/media/numbers_in_quran.jpg");

            Stack stack = new Stack();

            stack.addChild(view);
            stack.addChild(image);

            button1.onClicked(()->{
                stack.setVisibleChild(view);
            });

            button2.onClicked(()->{
                stack.setVisibleChild(image);
            });

            window.setTitle("Stack Demo");
            window.setTitlebar(titlebar);
            window.setChild(stack);
            window.show();
        });

        app.run(args.length, new Strs(args));  
    }

    public static void timer(String args[]){
        var app = new Application("com.example.hello", ApplicationFlags.FLAGS_NONE);

        app.onActivate(() -> {
            Window window = new ApplicationWindow(app);

            window.show();
        });

        Glib.timeoutAdd(1000, (handler,user_data)->{
            System.out.println("Hello.");
            return GlibConstants.SOURCE_CONTINUE;
        }, null);
        
        app.run(args.length, new Strs(args)); 
    }   

    public static int times = 0;
    public static void timer2(String args[]){
        var app = new Application("com.example.hello", ApplicationFlags.FLAGS_NONE);

        app.onActivate(() -> {
            Window window = new ApplicationWindow(app);

            window.show();
        });


        Glib.timeoutAdd(1000, (handler,user_data)->{
            System.out.println("Hello.");
            times++;

            if(times > 10)
                return GlibConstants.SOURCE_REMOVE;

            return GlibConstants.SOURCE_CONTINUE;
        }, null);
        
        app.run(args.length, new Strs(args)); 
    }
    
    public static void styling2(String args[]){
        var app = new Application("com.example.hello", ApplicationFlags.FLAGS_NONE);

        app.onActivate(() -> {
            Window window = new ApplicationWindow(app);

            CssProvider provider = new CssProvider();
            StyleContext.addProviderForDisplay(window.getDisplay(), provider.asStyleProvider(), 10000);

            HeaderBar titlebar = new HeaderBar();
            File f = new File("src/main/resources/themes");

            titlebar.packStart(themeButton("Default", "", provider));

            for(String name : f.list()){
                System.out.println("Name = "+ name);
                titlebar.packStart(themeButton(name, "src/main/resources/themes/"+name+"/gtk.css", provider));
            }

            TextView view = new TextView();

            window.setTitle("");
            window.setTitlebar(titlebar);
            window.setChild(view);
            window.show();
        });



        app.run(args.length, new Strs(args));  
    }

    public static Button themeButton(String name, String file_name , CssProvider provider){
        Button theme = new Button();
        theme.setLabel(name);
        theme.onClicked(()->{
            provider.loadFromPath("src/main/resources/themes/"+name+"/gtk.css");
        });

        return theme;
    }

    public static void styling(String args[]){
        var app = new Application("com.example.hello", ApplicationFlags.FLAGS_NONE);

        app.onActivate(() -> {
            Window window = new ApplicationWindow(app);

            CssProvider provider = new CssProvider();
            StyleContext.addProviderForDisplay(window.getDisplay(), provider.asStyleProvider(), 10000);
            provider.loadFromPath("src/main/resources/themes/canta-light/gtk.css");

            Button saveButton = Button.newWithLabelButton("Save");

            HeaderBar titlebar = new HeaderBar();
            titlebar.packStart(saveButton);


            TextView view = new TextView();
            view.setMarginStart(5);
            view.setMarginEnd(5);
            view.setMarginTop(5);
            view.setMarginBottom(5);

            window.setTitle("Notes");
            window.setTitlebar(titlebar);
            window.setChild(view);
            window.show();
        });



        app.run(args.length, new Strs(args));  
    }

    public static int lastNumber = 0;

    public static void program(String args[]){
        var app = new Application("com.example.hello", ApplicationFlags.FLAGS_NONE);

        app.onActivate(() -> {
            Window window = new ApplicationWindow(app);
            HeaderBar titlebar = new HeaderBar();

            Button saveButton = Button.newWithLabelButton("Save");
            Button addButton = Button.newWithLabelButton("Add");

            Stack stack = new Stack();

            Box mainBox = new Box(Orientation.HORIZONTAL, 0);
            Box buttonsBox = new Box(Orientation.VERTICAL, 0);

            mainBox.append(buttonsBox);
            mainBox.append(stack);
            ToggleButton grouper = new ToggleButton();

            addButton.onClicked(()->{
                lastNumber++;
                TextView view = new TextView();
                stack.addChild(view);
                stack.setVisibleChild(view);

                ToggleButton button = ToggleButton.newWithLabelToggleButton("Note " + lastNumber);
                button.setGroup(grouper);
                button.addCssClass("myButton");
                button.addCssClass("flat");
                button.onClicked(()->{
                    if(button.getActive())
                        stack.setVisibleChild(view);
                });

                buttonsBox.append(button);
            });

            saveButton.onClicked(()->{
                FileChooserDialog fileChooserDialog = new FileChooserDialog("Open File", window , FileChooserAction.OPEN , "Open" , 0 , "Cancel" , 1);

                fileChooserDialog.onResponse((int response)->{
                    if(response == 0)
                        System.out.println("Opening " + fileChooserDialog.asFileChooser().getFile().getPath().toString());
                    else
                        System.out.println("Operation Cancelled");
                    
                    fileChooserDialog.hide();
                });  

                fileChooserDialog.show();
            });

            buttonsBox.addCssClass("linked");

            stack.setHexpand(true);

            titlebar.packStart(saveButton);
            titlebar.packStart(addButton);

            CssProvider provider = new CssProvider();
            StyleContext.addProviderForDisplay(window.getDisplay(), provider.asStyleProvider(), 10000);
            provider.loadFromPath("src/main/resources/themes/canta-dark/gtk.css");

            CssProvider myprovider = new CssProvider();
            StyleContext.addProviderForDisplay(window.getDisplay(), myprovider.asStyleProvider(), 11000);

            String style = """
                    .myButton{
                        border:none;
                        border-radius: 0 0 0 0;
                    }
                    """;
            myprovider.loadFromData(style, style.length());


            window.setDefaultSize(400, 300);
            window.setTitle("Notes");
            window.setTitlebar(titlebar);
            window.setChild(mainBox);
            window.show();
        });

        app.run(args.length, new Strs(args));  
    }


    

    

}
