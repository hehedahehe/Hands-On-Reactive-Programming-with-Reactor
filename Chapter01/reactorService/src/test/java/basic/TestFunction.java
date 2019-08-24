package basic;

import org.junit.Test;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class TestFunction {

    /**
     * 乍一看，你可能会觉得这个革新并不特别，但是这种编程理念的变化，对后续我们构建分层可组合代码却尤其重要。
     * 调度者通过消费者处理类型化的数据和错误的回调。Reactor Stream 模块也基于该理念实现优雅编码。
     * 使用 Spring 这样的 IoC 容器的良好实践是利用 Java 配置特性返回无状态函数式 Beans。
     * 然后就可以从容地将代码块注入数据流管道，或者指派代码块的执行。
     */
    @Test
    public void test(){

        //消费者
        Consumer<String> consumer = new Consumer<String>(){
            @Override
            public void accept(String value){
                System.out.println(value);
            }
        };

        //生产者
        Function<Integer, String> transformation = integer -> ""+integer;
        Supplier<Integer> supplier = () -> 123;



        //调度者
        BiConsumer<Consumer<String>, String> biConsumer = (callback, value) -> {
            for(int i = 0; i < 10; i++){
                // 对要运行的最后逻辑运行做惰性求值
                callback.accept(value);
            }
        };

        // 注意生产者到双向消费者执行过程
        biConsumer.accept(
                consumer,
                transformation.apply(
                        supplier.get()
                )
        );

    }
}
