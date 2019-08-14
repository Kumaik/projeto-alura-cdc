    <div class="container">
        <form:form action="${s:mvcUrl('RPC#dataJson').arg(0,produtos.dataLancamento).build()}" modelAttribute="dataLancamento">
            <div class="form-group">
                <label>Data</label>
                <input type="date" pattern="dd-MM-yyyy" name="dataLancamento">
                <form:erros path="dataLancamento"/>
            </div>
            <button type="submit" class="btn btn-primary">Procurar</button>
        </form:form>
    </div>