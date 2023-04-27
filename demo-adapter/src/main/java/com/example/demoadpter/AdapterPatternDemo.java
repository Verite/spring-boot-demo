package com.example.demoadpter;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;

/**
 * 概念：适配器模式是一种结构型设计模式，它可以将不兼容的对象包装在适配器中，以便它们可以在一起工作。适配器模式可以让原本不兼容的类能够协同工作，从而提高代码的复用性和可维护性。
 * 作用：适配器模式的作用是将一个类的接口转换成客户端所期望的另一个接口。它可以让客户端通过统一的接口来访问不同的类，从而提高代码的灵活性和可扩展性
 * 优点：
 * 提高代码复用性：适配器模式可以将现有的类或接口转换成客户端所期望的接口，从而提高代码的复用性。这种模式可以将不兼容的接口进行转换，使得客户端可以使用现有的代码，而无需重新编写或修改代码。
 * <p>
 * 提高灵活性：适配器模式可以使得客户端可以使用不同的接口来访问相同的功能。这种模式可以将不同的接口进行转换，使得客户端可以使用不同的实现方式来访问相同的功能。
 * <p>
 * 可以增加系统的可扩展性：适配器模式可以将新的类或接口与现有的代码进行适配，从而增加系统的可扩展性。这种模式可以使得系统可以使用新的类或接口，而无需对现有的代码进行修改。
 * <p>
 * 缺点：
 * 可能增加代码的复杂性：适配器模式需要引入新的类或接口，从而增加代码的复杂性。这种模式需要编写适配器类来进行转换，而适配器类可能需要处理一些额外的逻辑，从而增加代码的复杂度。
 * <p>
 * 可能增加维护成本：适配器模式需要维护适配器类和被适配者类之间的关系，从而增加维护成本。这种模式可能需要修改适配器类或被适配者类的代码，从而增加维护的难度。
 * <p>
 * 使用场景
 * 主要考虑因素是两个接口之间的兼容性:
 * <p>
 * 将一个旧的、不兼容的类适配到新的接口上。
 * <p>
 * 将一个接口转换为另一个接口，以满足客户端的需求。
 * <p>
 * 将多个类的接口统一起来，以便客户端可以使用它们。
 * 定义目标接口（Target Interface）：这是客户端代码期望的接口。它定义了客户端需要的方法和属性。
 * 创建适配器类（Adapter Class）：适配器类是实现目标接口的类。它包装了一个不兼容的类，并将其转换为目标接口。
 * 创建不兼容的类（Incompatible Class）：这是需要适配的类。它可能是一个旧的、不兼容的类，或者是一个不符合目标接口的类。
 * 结构示意图：
 * +--------------+         +-----------------+        +------------------+
 * |  Target      |         |   Adapter       |        |    Adaptee        |
 * |  Interface   |         |                 |        |                  |
 * +--------------+         +-----------------+        +------------------+
 * | + method1()  |         | + method1()     |        | + methodSpecific()|
 * | + method2()  |  -----> | + method2()     |  ----> |                  |
 * | + method3()  |         |                 |        |                  |
 * +--------------+         +-----------------+        +------------------+
 * 定义播放器接口
 */
interface MediaPlayer {
    /**
     * 播放接口=
     * @param fileName 文件名
     */
    void play(String fileName);
}

/**
 * 定义待适配的MP3类
 */
@Slf4j
class Mp3Player {
    public void playMp3(String fileName) {
        log.info("Playing MP3 file: " + fileName);
    }
}

/**
 * 定义MP3适配器类，实现播放器接口
 */
class Mp3PlayerAdapter implements MediaPlayer {
    private Mp3Player mp3Player;

    public Mp3PlayerAdapter(Mp3Player mp3Player) {
        this.mp3Player = mp3Player;
    }

    @Override
    public void play(String fileName) {
        mp3Player.playMp3(fileName);
    }
}

/**
 * 测试适配器模式
 */
public class AdapterPatternDemo {
    public static void main(String[] args) {
        Mp3Player mp3Player = new Mp3Player();
        MediaPlayer mediaPlayer = new Mp3PlayerAdapter(mp3Player);
        mediaPlayer.play("song.mp3");
    }
}
