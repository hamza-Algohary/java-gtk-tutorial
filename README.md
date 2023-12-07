# Intro
This is a Gtk tutorial using Java.
# Objectives
Learning GUI programming with Java and Gtk.
# Prerequisities
- Basic knowledge of Java (Loop, Conditionals, OOP, etc.)
- Lambdas.
# Installation Guide For Windows
1. Download [this program](https://github.com/msys2/msys2-installer/releases/download/2023-10-26/msys2-x86_64-20231026.exe) and install it. (It's called MSYS2)
2. Open MSYS2 and paste the following commands:
```
pacman -S mingw-w64-x86_64-gtk4
```
```
pacman -S mingw-w64-x86_64-libadwaita
```
3. [Add `C:\msys64\mingw64\bin` to PATH](change-path-in-windows.md)

4. Clone this repository.

# Basics

### Creating a window.

```java
var app = new Application("com.example.hello", ApplicationFlags.FLAGS_NONE);

app.onActivate(() -> {
    Window window = new ApplicationWindow(app);
    window.show();
});

app.run(args.length, new Strs(args)); 
```

### Adding a button

```java
var app = new Application("com.example.hello", ApplicationFlags.FLAGS_NONE);

app.onActivate(() -> {
    Window window = new ApplicationWindow(app);

    Button button = new Button();
    button.setLabel("Click Me !");

    window.setChild(button);
    window.show();
});

app.run(args.length, new Strs(args));      
```
> [!IMPORTANT]
> You have to treat the onActivate() handler as your main() method for the GUI.
> Given that, I'm going to omit Application creationg from the following code and you have to put it inside onActivate() handler.


### Adding a label
```java
Window window = new ApplicationWindow(app);
Label label = new Label("HelloWorld");

window.setChild(label);
window.show();
``` 

### Organizing multiple widgets horizontally
```java
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
```
> [!NOTE]
> To organize them vertically, change Orientation.HORIZONTAL to Orientation.VERTICAL

### Controlling widgets expansion inside a box
```java
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
```

### Controlling Box Alignment

```java
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
```

> [!TIP]
> Available alignments are START, END, CENTER and FILL.
> START, END and CENTER squeezes children to a small area, while FILL makes them fill all the area.

### Some Notes
1. Every item that appears on the screen is called a widget.
2. Some widgets can contain other widgets, hence they are called containers.
3. Widgets inside a container are called children of that container.
3. Containers' job is to organize its children in a certain way.
4. Some containers can only hold one child (like Window).

# Useful Widgets
Visit [Gtk Widget Gallery](https://docs.gtk.org/gtk4/visual_index.html) to discover some of the available widgets in Gtk.

- [Picture](https://docs.gtk.org/gtk4/class.Picture.html)
```java
Picture pic = new Picture();
pic.setFilename("src/main/resources/media/numbers_in_quran.jpg");
```
- LevelBar
```java
LevelBar bar = new LevelBar();
bar.setMaxValue(100);
bar.setMinValue(0);
bar.setValue(30);
```
- TextView
- Entry
- PasswordEntry
- ToggleButton
- CheckButton
- Switch
- Spinner

Try to find the API of the above in [Gtk4 Documentation](https://docs.gtk.org/gtk4/)

# Event Handling.
An event is something interseting happening, like a button click, mouse motion, keyboard input, etc.

## Examples
### Print "Button Clicked !" whenever a button is pressed
```java
Window window = new ApplicationWindow(app);

Button button = new Button();
button.setLabel("Click Me !");

button.onClicked(()->{
    System.out.println("Button Clicked !");
});

window.setChild(button);
window.show();
```
### Print "Text Changed" whenever the text inside a TextView is changed
```java
Window window = new ApplicationWindow(app);

TextView view = new TextView();
view.getBuffer().onChanged(()->{
    System.out.println("Text Changed");
});

window.setChild(view);
window.show();
```

# Useful Containers
So far the containers we have seen are Window and Box, but there are more, check Gtk Widget Gallery's [containers section](https://docs.gtk.org/gtk4/visual_index.html#containers) for more containers.

### ScrolledWindow

If you have a large widget you should put in here to add a scollbar.

Let's take the following example of adding 100 buttons to a box, and adding the box to a ScrolledWindow
```java
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
```

### HeaderBar
To create a custom titlebar, use HeaderBar. This way you can add buttons to the titlebar for example.

```java
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
```

### Stack
A stack is a container that only shows one of its children at a time.

```java
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
```

# Dialogs
A dialog is a temorary window that shows or asks user some information, then closes.
Check Gtk4 Widget Gallery's [Windows](https://docs.gtk.org/gtk4/visual_index.html#windows) section for examples.

### AboutDialog
It's a window that shows information about the application (ex: program name, developer name, license, website, etc.)
```java
AboutDialog aboutDialog = new AboutDialog();
aboutDialog.setProgramName("Gtk Tutorial");
aboutDialog.setAuthors(new Strs(new String[]{"Hamza Algohary"}));
aboutDialog.setVersion("0.6.0");

aboutDialog.show();
```

### FileChooserDialog
A dialog to ask the user to select a file or a folder to open or save.
```java
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
```
Check the [documentation](https://docs.gtk.org/gtk4/class.FileChooserDialog.html) to understand the constructor.

# Timers
### Examples
#### Print "Hello." every 1 second (1000 milliseconds)
```java
Glib.timeoutAdd(1000, (handler,user_data)->{
    System.out.println("Hello.");
    return GlibConstants.SOURCE_CONTINUE;
}, null);
```
#### Print "Hello." every 1 second for 10 seconds only
```java
public static int times = 0;
```
```java
Glib.timeoutAdd(1000, (handler,user_data)->{
    System.out.println("Hello.");
    times++;

    if(times > 10)
        return GlibConstants.SOURCE_REMOVE;
        
    return GlibConstants.SOURCE_CONTINUE;
}, null);
```

# Tips

- Use setSizeRequest() on any widget to force a minimum size for it.
- Use setDefaultSize() to set window initial dimensions.

# Styling
Gtk widgets can be styled using CSS.
To load an external CSS file:
```java
CssProvider provider = new CssProvider();
StyleContext.addProviderForDisplay(window.getDisplay(), provider.asStyleProvider(), 10000);
provider.loadFromPath("src/main/resources/themes/canta-light/gtk.css");
```

You can also change the margin around a widget programmatically using these methods:
- setMarginStart()
- setMarginEnd()
- setMarginTop()
- setMarginBottom()
         





