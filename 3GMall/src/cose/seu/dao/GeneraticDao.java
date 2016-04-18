package cose.seu.dao;

import java.io.Serializable;
import java.util.List;

public interface GeneraticDao <T extends Serializable, ID extends Serializable>{
	
	public abstract T create(final T entity);

	public abstract T findById(final ID id);

	public abstract void delete(final ID id);

	public abstract void update(final T entity);
	
	public abstract void save(final T entity);
	
	public abstract List<T> findByHQL(final String strHQL, final Object[] params);

}
