package com.goodhealth.comm.util.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.nio.charset.Charset;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * redis工具类，方法定义：http://doc.redisfans.com
 *
 * @author WDH
 * @date 2018年1月30日
 */
@Service
@Component
@Slf4j
public class RedisService {

	@Autowired
	StringRedisTemplate stringRedisTemplate;

	private RedisLock redisLock = new RedisLock();

	/**
	 * 留白用于对key预处理
	 * @param key
	 * @return
	 */
	private String keyHandle(String key) {
		return "" + key;
	}

	/******************* key **********************/

	/**
	 * 删除key
	 * @date 2018年1月30日
	 */
	public void del(String key) {
		stringRedisTemplate.delete(keyHandle(key));
	}

	/**
	 * 批量删除key
	 * @date 2018年1月30日
	 */
	public void batchDel(Collection<String> keys) {
		List<String> campusKeys = new ArrayList<>();
		keys.forEach(e-> campusKeys.add(keyHandle(e)));
		stringRedisTemplate.delete(campusKeys);
	}

	/**
	 * 检查给定 key是否存在
	 * @date 2018年1月30日
	 */
	public Boolean exists(String key) {
		return stringRedisTemplate.hasKey(keyHandle(key));
	}

	/**
	 * 设置过期时间
	 * @param timeout 单位秒
	 */
	public Boolean expire(String key, long timeout) {
		return stringRedisTemplate.expire(keyHandle(key), timeout, TimeUnit.SECONDS);
	}

	/**
	 * 设置过期时间 自定义时间单位
	 * @param timeUnit 时间单位
	 */
	public Boolean expire(String key, long timeout, TimeUnit timeUnit) {
		return stringRedisTemplate.expire(keyHandle(key), timeout, timeUnit);
	}

	/**
	 * 设置过期时间  在某一天
	 * @param date 时间
	 */
	public Boolean expireAt(String key, Date date) {
		return stringRedisTemplate.expireAt(keyHandle(key), date);
	}

	/**
	 * 返回给定 key 的剩余生存时间,以秒为单位
	 *
	 * @param
	 */
	public Long ttl(String key) {
		return stringRedisTemplate.getExpire(keyHandle(key));
	}


	/**
	 * 修改 key
	 * @param key
	 * @return
	 */
	public void rename(String key,String newKey){
		stringRedisTemplate.boundValueOps(key).rename(newKey);
	}

	/******************* key----String **********************/

	/**
	 * 将 key所储存的值加上增量 delta,返回增加后的值
	 * @param
	 */
	public Long incrBy(String key, long delta) {
		return stringRedisTemplate.opsForValue().increment(keyHandle(key), delta);
	}

	/**
	 * 将字符串值 value 关联到 key
	 * @param
	 */
	public void set(String key, String value) {
		stringRedisTemplate.opsForValue().set(keyHandle(key), value);
	}

	/**
	 * 有失效时间的设置k-v
	 * @param key
	 * @param value
	 * @param expire
	 * @param timeUnit
	 */
	public void set(String key, String value, long expire, TimeUnit timeUnit) {
		stringRedisTemplate.opsForValue().set(keyHandle(key), value, expire, timeUnit);
	}

	/**
	 * 将 key的值设为 value ，当且仅当 key 不存在
	 * @param
	 */
	public Boolean setOnlyWhenExist(String key, String value) {
		return stringRedisTemplate.opsForValue().setIfAbsent(keyHandle(key), value);
	}

	/**
	 * 批量关联到 key
	 * @param map    <k,v>键值对
	 */
	public void mset(Map<String, String> map) {
		stringRedisTemplate.opsForValue().multiSet(map);
	}

	/**
	 * 返回 key所关联的字符串
	 * @date 2018年1月30日
	 * @param
	 */
	public String get(String key) {
		return stringRedisTemplate.opsForValue().get(keyHandle(key));
	}

	/******************* key---Hash **********************/

	/**
	 * 删除哈希表 key中的一个或多个指定域，不存在的域将被忽略
	 * @date 2018年1月30日
	 * @param  fields 变长参数
	 */
	public Long hdel(String key, Object... fields) {

		return stringRedisTemplate.opsForHash().delete(keyHandle(key), fields);
	}

	/**
	 * 将哈希表 key中的域 field 的值设为 value
	 * @param
	 */
	public void hset(String key, String field, String hashValue) {
		stringRedisTemplate.opsForHash().put(keyHandle(key), field, hashValue);
	}

	/**
	 * 同时将多个 field-value (域-值)对设置到哈希表 key 中
	 * @date 2018年1月30日
	 * @param
	 */
	public void hmset(String key, Map<String, String> map) {
		stringRedisTemplate.opsForHash().putAll(keyHandle(key), map);
	}

	/**
	 * 将哈希表 key 中的域 field 的值设置为 value ，当且仅当域 field 不存在
	 * @param
	 */
	public Boolean hsetOnlyWhenNotExist(String key, String field, String hashValue) {
		return stringRedisTemplate.opsForHash().putIfAbsent(keyHandle(key), field, hashValue);
	}

	/**
	 * 返回哈希表 key 中给定域 field 的值
	 * @date 2018年1月30日
	 * @param
	 */
	public String hget(String key, String field) {
		return (String) stringRedisTemplate.opsForHash().get(keyHandle(key), field);
	}

	/**
	 * 返回哈希表 key 中，所有的域和值
	 * @param
	 */
	public Map<Object, Object> hgetAll(String key) {
		return stringRedisTemplate.opsForHash().entries(keyHandle(key));
	}

	/**
	 * 返回哈希表 key 中的所有field
	 * @param
	 */
	public Set<Object> getHkeysFields(String key) {
		return stringRedisTemplate.opsForHash().keys(keyHandle(key));
	}

	/**
	 * 返回哈希表 key 中所有field的值
	 * @param
	 */
	public List<Object> getHkeysValues(String key) {
		return stringRedisTemplate.opsForHash().values(keyHandle(key));
	}

	/**
	 * 为哈希表 key 中的域 field 的值加上增量 delta
	 * @param
	 */
	public Long hincrBy(String key, String field, long delta) {
		return stringRedisTemplate.opsForHash().increment(keyHandle(key), field, delta);
	}

	/**
	 * 查看哈希表 key 中，给定域 field 是否存在
	 * @param
	 */
	public Boolean hexists(final String key, String hashKey) {
		return stringRedisTemplate.opsForHash().hasKey(keyHandle(key), hashKey);
	}

	/******************* key---List **********************/
	//  list入队顺序  a b c d --->    d c b a     从左到右进队列

	/**
	 * 删除并获取列表中的第一个元素
     * 左出队列
	 * @param
	 */
	public String lpop(String key) {
		return stringRedisTemplate.opsForList().leftPop(keyHandle(key));
	}

	/**
	 * 删除并获取列表中的第一个元素，或阻塞，直到有一个元素可用
     * 右出队列
	 * @param
	 */
	public String blockLpop(String key, long timeout, TimeUnit unit) {
		return stringRedisTemplate.opsForList().leftPop(keyHandle(key), timeout, unit);
	}

	/**
	 * 删除并获取列表中的最后一个元素
	 * @param
	 */
	public String rpop(String key) {
		return stringRedisTemplate.opsForList().rightPop(keyHandle(key));
	}

	/**
	 * 删除并获取列表中的最后一个元素，或阻塞，直到有一个元素可用
	 * @param
	 */
	public String blockRpop(String key, long timeout, TimeUnit unit) {
		return stringRedisTemplate.opsForList().rightPop(keyHandle(key), timeout, unit);
	}

	/**
	 * 返回列表 key 的长度
	 * @param
	 */
	public Long llen(String key) {
		return stringRedisTemplate.opsForList().size(keyHandle(key));
	}

	/**
	 * 将value 插入到列表 key 的表头
	 * @param
	 */
	public Long lpush(String key, String value) {
		return stringRedisTemplate.opsForList().leftPush(keyHandle(key), value);
	}

	/**
	 * 将值 value 插入到列表 key 的表头，当且仅当 key 存在并且是一个列表
	 * @param
	 */
	public Long lpushWhenExist(String key, String value) {
		return stringRedisTemplate.opsForList().leftPushIfPresent(keyHandle(key), value);
	}

	/**
	 * 将value 插入到列表 key 的表尾
	 * @param
	 */
	public Long rpush(String key, String value) {
		return stringRedisTemplate.opsForList().rightPush(keyHandle(key), value);
	}

	/**
	 * 将值 value 插入到列表 key 的表尾，当且仅当 key 存在并且是一个列表
	 * @param
	 */
	public Long rpushWhenExist(String key, String value) {
		return stringRedisTemplate.opsForList().rightPushIfPresent(keyHandle(key), value);
	}

    /**
     *  获取指定区间的value  下标从零开始
     * @param key
     * @param begin
     * @param end
     * @return
     */
	public List<String> lrange(String key, long begin,long end) {
		return stringRedisTemplate.opsForList().range(keyHandle(key), begin, end);
	}

	/******************* key---Set **********************/

	/**
	 * 将一个或多个 member 元素加入到集合 key 当中，已经存在于集合的 member 元素将被忽略
	 * @param
	 */
	public Long batchAddSkey(String key, String... values) {
		return stringRedisTemplate.opsForSet().add(keyHandle(key), values);
	}

	/**
	 * 返回集合 key 的基数(集合中元素的数量)
	 * @param
	 */
	public Long sizeSkey(String key) {
		return stringRedisTemplate.opsForSet().size(keyHandle(key));
	}

	/**
	 * 返回一个集合的全部成员，该集合是所有给定集合之间的差集
	 * @param
	 */
	public Set<String> sDiff(String key, String otherKey) {
		return stringRedisTemplate.opsForSet().difference(keyHandle(key), otherKey);
	}

	/**
	 * 返回一个集合的全部成员，该集合是所有给定集合之间的差集
	 * @param
	 */
	public Set<String> sDiff(String key, Collection<String> otherKeys) {
		return stringRedisTemplate.opsForSet().difference(keyHandle(key), otherKeys);
	}

	/**
	 * 返回一个集合的全部成员，该集合是所有给定集合的交集
	 * @param
	 */
	public Set<String> sInter(String key, String otherKey) {
		return stringRedisTemplate.opsForSet().intersect(keyHandle(key), otherKey);
	}

	/**
	 * 返回一个集合的全部成员，该集合是所有给定集合的交集
	 * @param
	 */
	public Set<String> sInter(String key, Collection<String> otherKeys) {
		return stringRedisTemplate.opsForSet().intersect(keyHandle(key), otherKeys);
	}

	/**
	 * 判断 member 元素是否集合 key 的成员
	 * @param
	 */
	public Boolean sIsMember(String key, String member) {
		return stringRedisTemplate.opsForSet().isMember(keyHandle(key), member);
	}

	/**
	 * 返回集合 key 中的所有成员
	 * @param
	 */
	public Set<String> sMembers(String key) {
		return stringRedisTemplate.opsForSet().members(keyHandle(key));
	}

	/**
	 * 移除集合 key 中的一个或多个 member 元素，不存在的 member 元素会被忽略
	 * @param
	 */
	public Long sRemove(String key, String... values) {
		return stringRedisTemplate.opsForSet().remove(keyHandle(key), values);
	}

	/**
	 * 返回一个集合的全部成员，该集合是所有给定集合的并集
	 * @param
	 */
	public Set<String> sUnion(String key, String otherKey) {
		return stringRedisTemplate.opsForSet().union(keyHandle(key), otherKey);
	}

	/**
	 * 返回一个集合的全部成员，该集合是所有给定集合的并集
	 * @param
	 */
	public Set<String> sUnion(String key, Collection<String> otherKeys) {
		return stringRedisTemplate.opsForSet().union(keyHandle(key), otherKeys);
	}

	/******************* key---Zset **********************/

	/**
	 * 将一个或多个 member 元素及其 score 值加入到有序集 key 当中v
	 * @param
	 */
	public Boolean zAdd(String key, String value, double score) {
		return stringRedisTemplate.opsForZSet().add(keyHandle(key), value, score);
	}

	/**
	 * 返回有序集 key 元素的个数
	 * @param
	 */
	public Long zcard(String key) {
		return stringRedisTemplate.opsForZSet().zCard(keyHandle(key));
	}

	/**
	 * 返回有序集 key 中， score 值在 min 和 max 之间(默认包括 score 值等于 min 或 max)的成员的数量
	 * @param
	 */
	public Long zCount(String key, double min, double max) {
		return stringRedisTemplate.opsForZSet().count(keyHandle(key), min, max);
	}

	/**
	 * 为有序集 key 的成员 member 的 score 值加上增量 delta
	 * @param
	 */
	public Double zIncrby(String key, String value, double delta) {
		return stringRedisTemplate.opsForZSet().incrementScore(keyHandle(key), value, delta);
	}

	/**
	 * 返回有序集 key 中，指定区间内的成员,
     * 其中成员的位置按 score 值递增(从小到大)来排序
	 * @param
	 */
	public Set<String> zRange(String key, long start, long end) {
		return stringRedisTemplate.opsForZSet().range(keyHandle(key), start, end);
	}

	/**
	 * 返回有序集 key 中，所有 score 值介于 min 和 max 之间(包括等于 min 或 max)的成员。有序集成员按
	 * score,值递增(从小到大)次序排列
	 * @param
	 */
	public Set<String> zRangeByScore(String key, double min, double max) {
		return stringRedisTemplate.opsForZSet().rangeByScore(keyHandle(key), min, max);
	}

	/**
	 * 返回有序集 key 中成员 member 的排名。其中有序集成员按 score 值递增(从小到大)顺序排列。
     * 排名以 0 为底
	 * @param
	 */
	public Long zRank(String key, String member) {
		return stringRedisTemplate.opsForZSet().rank(keyHandle(key), member);
	}

	/**
	 * 移除有序集 key 中，指定排名(rank)区间内的所有成员
	 * @param
	 */
	public Long zRemoveRangeByRank(String key, long start, long end) {
		return stringRedisTemplate.opsForZSet().removeRange(keyHandle(key), start, end);
	}

	/**
	 * 移除有序集 key 中，所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员
	 * @param
	 */
	public Long zRemoveRangeByScore(String key, double min, double max) {
		return stringRedisTemplate.opsForZSet().removeRangeByScore(keyHandle(key), min, max);
	}

	/**
	 * 返回有序集 key 中，指定区间内的成员。其中成员的位置按 score 值递减(从大到小)来排列。
	 * @param
	 */
	public Set<String> zReverseRange(String key, long start, long end) {
		return stringRedisTemplate.opsForZSet().reverseRange(keyHandle(key), start, end);
	}

	/**
	 * 返回有序集 key 中， score 值介于 max 和 min 之间(默认包括等于 max 或 min)的所有的成员。
     * 有序集成员按score,值递减(从大到小)的次序排列
	 * @param
	 */
	public Set<String> zReverseRangeByScore(String key, double min, double max) {
		return stringRedisTemplate.opsForZSet().reverseRangeByScore(keyHandle(key), min, max);
	}

	/**
	 * 返回有序集 key 中成员 member 的排名。其中有序集成员按 score 值递减(从大到小)排序。排名以 0 为底
	 * @param
	 */
	public Long zrevrank(String key, String member) {
		return stringRedisTemplate.opsForZSet().reverseRank(keyHandle(key), member);
	}

	/**
	 * 返回有序集 key 中，成员 member 的 score 值
	 * @param
	 */
	public Double zscore(String key, String member) {
		return stringRedisTemplate.opsForZSet().score(keyHandle(key), member);
	}

	/******************* Pub/Sub **********************/

	/**
	 * 将信息 message 发送到指定的频道 channel
	 * @param
	 */
	public void publish(String channel, String message) {
		stringRedisTemplate.convertAndSend(channel, message);
	}

	/******************* serial **********************/

	/**
	 * 获取redisTemplate的序列化
	 * @param
	 */
	public RedisSerializer<String> getSerializer() {
		return stringRedisTemplate.getStringSerializer();
	}


	public boolean lock(String key,int timeout) throws InterruptedException {
		return redisLock.lock(keyHandle(key),timeout);
	}

	public boolean unlock(String key) {
		return redisLock.unlock(keyHandle(key));
	}

	class RedisLock {

		private static final int DEFAULT_ACQUIRY_RESOLUTION_MILLIS = 100;

//		/**
//		 * Lock key path.
//		 */
//		private String lockKey;

		/**
		 * 锁超时时间，防止线程在入锁以后，无限的执行等待
		 */
		private int expireMsecs = 30 * 1000;

		/**
		 * 锁等待时间，防止线程饥饿
		 */
		private int timeoutMsecs = 5 * 1000;



		private String get(final String key) {
			return stringRedisTemplate.opsForValue().get(keyHandle(key));
		}

		private boolean setNX(final String key, final String value) {
			return stringRedisTemplate.opsForValue().setIfAbsent(keyHandle(key), value);
		}

		private boolean setNX(final String key,int expireSecs) {

//			RedisCallback<String> callback2 = new RedisCallback<String>() {
//				@Override
//				public String doInRedis(RedisConnection connection) throws DataAccessException {
//					JedisCommands commands = (JedisCommands) connection.getNativeConnection();
//					return commands.set(RedisLock.this.keyHandle(key), "1", "NX", "EX", expireSecs);
//				}
//			};
//			RedisCallback<String> callback = (connection) -> {
//				JedisCommands commands = (JedisCommands) connection.getNativeConnection();
//				return commands.set(keyHandle(key), "1", "NX", "EX", expireSecs);
//			};
			RedisCallback<Boolean> callback = (connection) -> {
				return connection.set(keyHandle(key).getBytes(Charset.forName("UTF-8")), UUID.randomUUID().toString().getBytes(Charset.forName("UTF-8")), Expiration.seconds(TimeUnit.SECONDS.toSeconds(expireSecs)), RedisStringCommands.SetOption.SET_IF_ABSENT);
			};
			return (Boolean)stringRedisTemplate.execute(callback);
		}

		private String getSet(final String key, final String value) {
			return stringRedisTemplate.opsForValue().getAndSet(keyHandle(key), value);
		}

		/**
		 * @Description: lock 即时锁 强制过期时间  缺点是会有过期时间内一直持有锁的隐患
		 *
		 * @param lockKey :
		 * @param timeout :
		 * @return: boolean
		 * @auther: wanglei
		 * @date: 2019/1/11 上午12:41
		 */
		public boolean lock(String lockKey,int timeout) throws InterruptedException {

			if (0 == timeout) {
				timeout = timeoutMsecs;
			}

			try {
				if (this.setNX(lockKey, timeout)) {
					// lock acquired
					return true;
				}
			} catch (Exception e) {
				log.error("lock::lockKey = [{}], timeout = [{}]",lockKey, timeout,e);

			}
			return false;
//			while (timeout >= 0) {
//				long expires = System.currentTimeMillis() + expireMsecs + 1;
//				String expiresStr = String.valueOf(expires); // 锁到期时间
//				if (this.setNX(lockKey, expiresStr)) {
//					// lock acquired
//					return true;
//				}
//
//				String currentValueStr = this.get(lockKey); // redis里的时间
//				if (currentValueStr != null && Long.parseLong(currentValueStr) < System.currentTimeMillis()) {
//					// 判断是否为空，不为空的情况下，如果被其他线程设置了值，则第二个条件判断是过不去的
//					// lock is expired
//
//					String oldValueStr = this.getSet(lockKey, expiresStr);
//					// 获取上一个锁到期时间，并设置现在的锁到期时间，
//					if (oldValueStr != null && oldValueStr.equals(currentValueStr)) {
//						// 防止误删（覆盖，因为key是相同的）了他人的锁——这里达不到效果，这里值会被覆盖，但是因为什么相差了很少的时间，所以可以接受
//						// [分布式的情况下]:如过这个时候，多个线程恰好都到了这里，但是只有一个线程的设置值和当前值相同，他才有权利获取锁
//						// lock acquired
//						return true;
//					}
//				}
//				timeout -= DEFAULT_ACQUIRY_RESOLUTION_MILLIS;
//				/*
//				 * 延迟100 毫秒, 这里使用随机时间可能会好一点,可以防止饥饿进程的出现,即,当同时到达多个进程,
//				 * 只会有一个进程获得锁,其他的都用同样的频率进行尝试,后面有来了一些进行,也以同样的频率申请锁,这将可能导致前面来的锁得不到满足.
//				 * 使用随机的等待时间可以一定程度上保证公平性
//				 */
//				Thread.sleep(DEFAULT_ACQUIRY_RESOLUTION_MILLIS);
//
//			}
//			return false;
		}

		/**
		 * Acqurired lock release.
		 */
		public boolean unlock(String lockKey) {

			return stringRedisTemplate.delete(keyHandle(lockKey));
		}

	}

/*	public static void main(String[] args) {
		//连接本地的 Redis 服务

		Jedis jedis = new Jedis("127.0.0.1");
		System.out.println(jedis.set("1","1"));
		System.out.println("连接成功");
		System.out.println(TimeUnit.SECONDS.toSeconds(1));
	}*/
}
