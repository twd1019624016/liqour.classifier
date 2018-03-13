package classifier.detection;

import java.util.List;

/**
 *
 * @param <T> 待检测类
 * @param <V> 返回结果
 * @param <S> 标准数据
 */
public interface Classifier<T, V,S> {

	/**
	 * @param t 检测数据
	 * @param source 标准数据
	 * @param threshold 阈值
	 * @return
	 */
	V detect(T t,List<S> source);
	
}
